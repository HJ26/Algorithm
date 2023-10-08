import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int NR, NC, K, MIN;
	static int[][] arr, arrTmp;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static boolean[] visit;
	static Rotate[] rotates, permuRotate;
	
	static class Rotate{	// 회전 정보를 저장할 클래스
		int r,c,s;
		public Rotate() {}
		public Rotate(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		NR = Integer.parseInt(st.nextToken());
		NC = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[NR][NC];
		arrTmp = new int[NR][NC];
		rotates = new Rotate[K];
		permuRotate = new Rotate[K];
		
		// 데이터 저장하기
		
		// 배열 저장
		for(int n = 0; n < NR; n++) {
			st =  new StringTokenizer(br.readLine());
			for(int c = 0; c < NC; c++) {
				arr[n][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 회전 정보 저장
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			rotates[k] = new Rotate(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())); 
		}
		
		// 회전 순열 찾기
		visit = new boolean[K];
		MIN = Integer.MAX_VALUE;
		find(0);
		
		// 최소값 출력
		System.out.println(MIN);
	}

	// 순열 뽑기
	private static void find(int sidx) {
		
		// 순열을 다 뽑았을 때
		if(sidx == K) {
			// 최소값 찾기
			doRotate();
			return;
		}
		
		// 뽑기
		for(int i = 0; i < K; i++) {	
			if(visit[i]) continue;	// 이미 방문했으면 넘기기
			visit[i] = true;		// 방문 표시
			permuRotate[sidx] = rotates[i];	// 값 저장
			find(sidx+1);			// 다음 값 확인
			visit[i] = false;		// 방문 안했다고 하고 넘기기
		}
	}
	
	// 회전시켜서 최소값 찾기
	private static void doRotate() {
		
		// 배열 복사본 만들기
		for(int n = 0; n < NR; n++) {
			for(int c = 0; c < NC; c++) {
				arrTmp[n][c] = arr[n][c];
			}
		}
		
		// 회전시키기
		// 현재 위치의 값을 다음 위치의 값에 넣기
		for(Rotate rot : permuRotate) {
			
			// 각 사각형별 시작점과 종료점 ( 큰 사각형부터 시작 )
			int startR = rot.r - rot.s;
			int startC = rot.c - rot.s;
			int endR = rot.r + rot.s;
			int endC = rot.c + rot.s;
			
			int dir = 0;			// 방향
			int currR = startR;						// 탐색 시작 위치 ( 현재 위치 )
			int currC = startC;		
			int currValue = arrTmp[currR][currC];	// 현재위치의 값
			int nextValue;							// 바꿀 위치의 원본 값
			int nextR, nextC;						// 바꿀 위치
			while(endR - startR >= 1) {
				
				// 바꿀 위치의 값 구하기
				nextR = currR + dr[dir];
				nextC = currC + dc[dir];
				
				// 범위에 맞는지 확인
				// 내가 바꿀 위치의 값이 사각형 범위 안에 없으면 다음 방향으로 넘어가서 탐색
				if(nextR > endR || nextR < startR || nextC > endC || nextC < startC ) {
					dir++;
					
					// 방향이 4가 된다면 하나의 사각형에 대해 바꾸기를 완료
					// 하나의 사각형에 대해 다 완료했다면
					if(dir > 3) {
						
						// 사각형 범위 바꾸기
						startR++;
						startC++;
						endR--;
						endC--;
						
						// 사각형 시작점 바꾸기
						currR = startR;
						currC = startC;
						currValue = arrTmp[currR][currC];
						
						// 방향 초기화
						dir = 0;
						continue;
					}
					// 다음 위치 값 가져오기
					nextR = currR + dr[dir];
					nextC = currC + dc[dir];
				}
				
				// 바꾸기
				nextValue = arrTmp[nextR][nextC];	// 바꾸기 전 원본값
				arrTmp[nextR][nextC] = currValue;	// 내 위치의 원본 값 대입
				currR = nextR;						// 위치 바꾸기
				currC = nextC;
				currValue = nextValue;				// 바꾸기 전 원본값을 현재 위치의 원본값으로 저장
				
			}
		}
		
		// 최소값 찾기
		for(int n = 0; n < NR; n++) {
			int sum = 0;
			for(int c = 0; c < NC; c++) {
				sum += arrTmp[n][c];
			}
			MIN =  ( MIN > sum ? sum : MIN );
		}
	}
}
