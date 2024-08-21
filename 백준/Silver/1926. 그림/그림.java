import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[][] visit;
	static int[][] paper;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int nDraw = 0, maxArea = 0, area = 0, N, M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		visit = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) paper[r][c] = Integer.parseInt(st.nextToken());
		}
		
		
		// 모든 점에 대하여 탐색
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				
				// 방문했거나 그림이 아니면 넘기기
				if(visit[r][c] || paper[r][c] == 0) continue;
				
				// 방문처리
				visit[r][c] = true;
				
				// 그림 개수 추가 및 넓이 초기화
				nDraw++;
				area = 1;
				
				// 넓이 탐색
				bfs(r,c);
				
				// 최대값 갱신
				maxArea = Math.max(maxArea, area);
				
			}
		}
		
		// 출력
		System.out.println(nDraw);
		System.out.println(maxArea);
		
	}

	private static void bfs(int r, int c) {
		
		// 현재 점 기준 사방탐색
		for(int dir = 0; dir < 4; dir++) {
			
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			
			// 종이를 벗어나거나, 방문한적이 있거나, 그림이 아니면 넘기기
			if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M || visit[nextR][nextC] || paper[nextR][nextC] == 0) continue;
			
			// 방문처리
			visit[nextR][nextC] = true;
			
			// 넓이 추가
			area++;
			// 현재점을 기준으로 다시 탐색
			bfs(nextR, nextC);
		}
		
	}
}
