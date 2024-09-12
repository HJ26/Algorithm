import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] painting;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N, nArea, nBlindArea;
	
	static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		
		N = Integer.parseInt(br.readLine());
		painting = new char[N][N];
		
		for(int r = 0; r < N; r++) {
			st = br.readLine();			
			for(int c = 0; c < N; c++) {
				painting[r][c] = st.charAt(c);
			}
		}
		
		visit = new boolean[N][N];
		
		// 구역 개수 구하기
		int area = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				// 방문한적 없는 경우
				if(!visit[r][c]) {
					// 같은 구역 찾기 시작
					visit[r][c] = true;
					bfs(r,c);
					area++;	// 구역 하나 추가
				}
				
				// 다음 색약구역 구하기를 위해 G를 R로 변경
				if(painting[r][c] == 'G') painting[r][c] = 'R';
			}
		}
		
		
		// 방문처리 초기화
		for(int i = 0; i < N; i++) Arrays.fill(visit[i],false);
		
		// 적록색약 구역 구하기
		int abArea = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				// 구역 구하기 반벅
				if(!visit[r][c]) {
					visit[r][c] = true;
					bfs(r,c);
					abArea++;
				}
			}
		}
		
		System.out.println(area + " " + abArea);
	}

	private static void bfs(int r, int c) {
	
		// 큐에 현재 위치 저장
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {r,c});
		
		// 현재 구역 색상 저장
		char curColor = painting[r][c];
		
		// 큐가 빌 때까지 반복
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			int curR = cur[0];
			int curC = cur[1];
			
			// 사방탐색
			for(int dir = 0; dir < 4; dir++) {
				int nextR = curR + dr[dir];
				int nextC = curC + dc[dir];
				
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || visit[nextR][nextC]) continue;
				
				// 다음 구역 색상이 기준 색상과 동일하면
				if( painting[nextR][nextC] == curColor ) {
					// 방문 처리 후 큐에 위치 추가
					visit[nextR][nextC] = true;
					que.add(new int[] {nextR, nextC});
				}
				
			}
		}
	}
}
