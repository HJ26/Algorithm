import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	
	static int[][] cheese;			// 치즈 판을 저장할 변수
	static int R, C;				// 가로 세로 길이

	static boolean[][] visit;		// 방문처리
	static List<Integer> nCheese = new ArrayList<Integer>();	// 치즈개수를 저장할 리스트
	
	// 위치를 저장할 클래스
	static class Place {
		int r;
		int c;
		
		public Place() {}
		public Place(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cheese = new int[R][C];
		visit = new boolean[R][C];
		
		// 데이터 입력
		for(int r = 0; r < R; r++ ) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				cheese[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 치즈 녹이기
		
		int time = 0;
		int cnt = getCheese(); 		// 초기 치즈 개수
		nCheese.add(cnt);
		while(true) {
			
			// 시간 증가
			time++;
			
			// 모서리 찾기
			findEdge(0,0);
			//치즈 녹이기
			melting();
			
			// 방문처리 초기화
			// 다음에 치즈를 녹일때 이전 시간의 방문여부에 영향을 받지 않기 위함
			for(int i = 0; i < R; i++) Arrays.fill(visit[i], false);
			
			// 남은 치즈 개수 구하기
			cnt = getCheese();
			
			if(cnt == 0) break;
			else nCheese.add(cnt);
		}
		
		
		// 결과값 출력
		sb.append(time).append("\n");		// 걸린 시간
		sb.append(nCheese.get(time-1));		// 다 녹기 직전 개수
		System.out.println(sb.toString());
		
	}
	private static void findEdge(int r, int c) {
		
		// 시작점 큐에 저장
		Queue<Place> que = new LinkedList<Main.Place>();
		que.add(new Place(r,c));
		visit[r][c] = true;
		
		// 시작점을 기준으로 만나는 치즈(1)를 모서리(2)로 변경
		while(!que.isEmpty()) {
			Place cur = que.poll();
			
			// 사방탐색
			for(int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];
				
				if(nr < 0 || nr >= R ||  nc < 0 || nc >= C || visit[nr][nc]) continue;
				
				visit[nr][nc] = true;
				if( cheese[nr][nc] == 1 ) cheese[nr][nc] = 2;
				else if( cheese[nr][nc] == 0 ) que.add(new Place(nr,nc)); 
			}
		}
		
	}
	private static void melting() {
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(cheese[r][c] == 2) cheese[r][c] = 0;
			}
		}
	}
	private static int getCheese() {
		int cnt = 0 ;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(cheese[r][c] == 1) cnt++;
			}
		}
		return cnt;
	}


}
