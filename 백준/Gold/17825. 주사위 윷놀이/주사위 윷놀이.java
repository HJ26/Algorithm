import java.util.*;
import java.io.*;

public class Main {
	
	// 변수 설정
	static int maxScore = 0;
	static int[] place = { 0, 0, 0, 0 };			// 현재 내가 이동한 총 칸수
	static int[] dice = new int[10];				// 주사위 값
	static int[] visitPoint = { -1, -1, -1, -1};	// 방문한 포인트 번호
	static int[] pointPlace = { -1, -1, -1, -1 };	// 포인트 도착 후 이동한 칸 수
	static int[] currPlace = { 0, 0, 0, 0 };		// 현재 서있는 지점의 포인트
	
	// 포인트에 도착하면 이동할 경로
	static int[][] shortCut = { { 13, 16, 19, 25, 30, 35, 40 },
								{ 22, 24, 25, 30, 35, 40 },
								{ 28, 27, 26, 25, 30, 35, 40 }
	};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 변수 초기화
		// 주사위 값 받기
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++) dice[i] = Integer.parseInt(st.nextToken());
		
		// 말 움직이기
		move(0, 0);
		
		// 최대값 출력
		bw.write(Integer.toString(maxScore));
		bw.close();
	}

	private static void move(int score, int diceNum) {
		
		// 기저조건
		// 모든 주사위를 다 봤으면 멈추기
		if(diceNum == 10) {
			maxScore = Math.max(maxScore, score);
			return;
		}

		// 순서대로 말 4개 움직이기
		int lastPlace;
		int lastPointPlace;
		int plusScore;
		int lastVisitPoint;
		int lastCurrPlace;
		moving: for(int i = 0; i < 4; i++) {
			
			// 말이 이미 도착했으면 다음 말 보기
			if(currPlace[i] > 40) continue moving;
			
			// 이전 말이 출발했을 경우에만 다음 말 움직이기
			if( i != 0 && place[i-1] == 0) continue moving;
			
			// 움직이기 이전 값 저장
			lastPlace = place[i];
			lastPointPlace = pointPlace[i];
			lastVisitPoint = visitPoint[i];
			lastCurrPlace = currPlace[i];
			
			// 다음 칸 확인하기
			place[i] = lastPlace + dice[diceNum];	// 내가 이동할 칸수
		
			if(visitPoint[i] == -1) { 	// 과거에 포인트를 지나지 않았을때
				
				// 추가 점수 확인
				plusScore = place[i] * 2;
				
				// 현재 내가 서있는 위치 확인하기
				currPlace[i] = plusScore;
				
				// 다음칸이 맵 안에 있는지 확인
				// 맵 밖에 있으면 포인트 획득 못함
				if( plusScore > 40) {
					
					// 맵 밖에 있으면 이동 안하고 점수 확인
					maxScore = Math.max(maxScore, score);
					
					// 초기화 안하고 이동시키기 ( 나가게 하고 그냥 진행 )
					currPlace[i] = 42;
					move(score, diceNum+1);
					
					//초기화 하고 다음 말 이동시키기 ( 이동 안시키고 다음 말 이동 )
					currPlace[i] = lastCurrPlace;
					place[i] = lastPlace;
					continue moving;
					
				}
				
			} else { // 과거에 포인트를 방문한 적이 있을때
				
				// 다음 위치가 맵 안에 있는지 확인
				pointPlace[i] = pointPlace[i]+dice[diceNum]; 			// 포인트에 도착한 적 있다면 그 이후 움직인 칸수
				
				if(pointPlace[i] >= shortCut[visitPoint[i]-1].length) {
					maxScore = Math.max(maxScore, score);
					
					// 초기화 안하고 이동시키기 ( 말 나가게 하고 그냥 진행 )
					currPlace[i] = 42;
					move(score, diceNum+1);
					
					//초기화 하고 다음 말 이동시키기 ( 이동 안시키고 다음 말 이동 )
					currPlace[i] = lastCurrPlace;
					place[i] = lastPlace;
					pointPlace[i] = lastPointPlace;
					continue moving;
				}
				
				
				// 추가 점수 확인
				plusScore = shortCut[visitPoint[i]-1][pointPlace[i]];
				
				// 다음 위치 저장
				currPlace[i] = plusScore;
				if(plusScore == 30) currPlace[i] = 31;
				
			}
			
			// 포인트인지 확인
			if(visitPoint[i] == -1 && plusScore % 10 == 0 && plusScore != 40) {
				visitPoint[i] = plusScore / 10;
			}
			
			// 다른 말이 있는지 확인
			for(int j = 0; j < 4; j++) {
				
				
				if( j == i   ) continue;	// 다른 말과 비교
				
				
				// 같은 지점이면 안가기
				if( ( visitPoint[i] == visitPoint[j] && place[i] == place[j]) ||	// 방문한 포인트가 같고 이동한 칸의 개수가 동일한 경우
					( visitPoint[i] != -1 && visitPoint[j] != -1 && currPlace[i] == currPlace[j]) ||	// 어느점이든 포인트에 방문을 했고, 값이 같은 경우 ( 마지막 라인인 경우 )
					( currPlace[i] == 40 && currPlace[j] == 40 ) ) {									// 포인트 방문 여부와 상관없이 40에 방문한경우
					
					// 초기화 하고 다음 말 움직이기
					place[i] = lastPlace;
					pointPlace[i] = lastPointPlace;
					visitPoint[i] = lastVisitPoint; 
					currPlace[i] = lastCurrPlace;
					continue moving;
				}
			}
			
			
			// 움직이기
			move(score + plusScore, diceNum+1);
			
			// 이동이 끝났으면 다시 초기화
			place[i] = lastPlace;
			pointPlace[i] = lastPointPlace;
			visitPoint[i] = lastVisitPoint;
			currPlace[i] = lastCurrPlace;
		}
	}
}