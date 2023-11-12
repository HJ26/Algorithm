import java.io.*;
import java.util.*;

public class Main {
	static int N,K, maxScore = 0;
	static int[] attack, dx = {-1, 1, 0, 0}, dy = {0,0,-1,1};
	static int[][][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 지도 크기
		K = Integer.parseInt(br.readLine());	// 사격 횟수
		
		// 지도 정보 받기
		map = new int[N][N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
				map[i][j][1] = map[i][j][0];
			}
		}
		
		// 총알 공격력
		attack = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			attack[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 쏘기
		shoot(0, 0, map);
		System.out.println(maxScore);
	}
	private static void shoot(int nAttack, int score, int[][][] map) {
		
		// K번 쐈으면 최대 점수 갱신
		if(nAttack == K) {
			maxScore = Math.max(maxScore, score);
			return;
		}
		
		// 지도 정보 복사
		int[][][] mapTmp = new int[N][N][2];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				mapTmp[i][j][0] = map[i][j][0];
				mapTmp[i][j][1] = map[i][j][1];
			}
		}
		
		// 쏘기
		loop : for(int i = 0; i < N; i++) {		// 한줄씩 쏘기
			for(int j = 0; j < N; j++) {		// 그 줄의 각 열 확인
				if(mapTmp[i][j][0] != 0) {		// 0이 아니면
					if(mapTmp[i][j][0] >= 10) {	// 10점 이상인 보너스 타겟일때
						mapTmp[i][j][0] = 0;	// 0점으로 바꾸고
						shoot(nAttack+1,score+mapTmp[i][j][1],mapTmp);	// 다음 쏘기
					}
					else {	// 보너스 타겟이 아니면
						mapTmp[i][j][0] -= attack[nAttack];		// 공격력만큼 감소시키기
						if(mapTmp[i][j][0] <= 0) {				// 감소한 값이 0 이하면
							mapTmp[i][j][0] = 0;				// 0으로 바꾸고
							if(mapTmp[i][j][1] > 3) {			// 4점 이상일때 ( 상하좌우에 새로운 타겟을 만들 수 있을 때 )	
								for(int dir = 0; dir < 4; dir++) {	// 사방탐색하면서
									int nextX = i + dx[dir];
									int nextY = j + dy[dir];
									// 지도 밖이고 0점이 아닌 과녁이면 다음 방향 보기
									if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || mapTmp[nextX][nextY][0] != 0) continue;
									
									// 0점인 과녁에 대해 초기점수의 1/4로 새로운 과녁 생성
									mapTmp[nextX][nextY][0] = mapTmp[i][j][1] / 4;
									mapTmp[nextX][nextY][1] = mapTmp[nextX][nextY][0];
								}								
							}
							// 사라진 과녁의 초기값만큰 점수 갱신하고 쏘기
							shoot(nAttack+1, score + mapTmp[i][j][1], mapTmp);
						}else {
							//0점이 안되면 점수 갱신 없이 쏘기
							shoot(nAttack+1, score, mapTmp);
						}
					}
					// 바뀐 값 다시 원래대로 돌리기
					for(int k = 0; k < N; k++) {
						for(int l = 0; l < N; l++) {
							mapTmp[k][l][0] = map[k][l][0];
							mapTmp[k][l][1] = map[k][l][1];
						}
					}
					// 쐈으니까 다음 행 쐈을 경우 생각하기
					continue loop;
				}
			}
		}
		
		
		
	}
}
