import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int[][] map;
	static class Point{
		int x,y,cnt;
		public Point() {

		}
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++ ) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		

		System.out.println(BFS());
		
	}
	
	
	private static int BFS() {
		
		Queue<Point> que = new LinkedList<>();
		
		int currX = 0;
		int currY = 0;
		int currCnt = 1;
		que.offer(new Point(currX, currY, currCnt));

		boolean[][] visit = new boolean[N][M];
		visit[0][0] = true;
		
		while(!que.isEmpty()) {
			Point curr = que.poll();
			currX = curr.x;
			currY = curr.y;
			currCnt = curr.cnt;
			
			if(currX == N-1 && currY == M-1) break;
			
			for(int dir = 0; dir < 4; dir++) {
				int nextX = currX + dx[dir];
				int nextY = currY + dy[dir];
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || visit[nextX][nextY] || map[nextX][nextY] == 0) continue;
				
		
				visit[nextX][nextY] = true;
				que.add(new Point(nextX, nextY, currCnt+1));
			}
		}

		return currCnt;
	}
}
