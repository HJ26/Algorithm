import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int[][] map;
	public static boolean[][] visit;
	public static int N, M, A, B, startX, startY, endX, endY;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 데이터 채우기
		map = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken())-1;
		startY = Integer.parseInt(st.nextToken())-1;
		

		st = new StringTokenizer(br.readLine());
		endX = Integer.parseInt(st.nextToken())-1;
		endY = Integer.parseInt(st.nextToken())-1;
		
		System.out.println(BFS());
	}

	private static int BFS() {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {startX, startY});
		visit[startX][startY] = true;
		int cnt = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			while(--size >= 0) {
				int[] currInfo = que.poll();
				int currX = currInfo[0];
				int currY = currInfo[1];
				if( currX == endX && currY == endY ) return cnt;
				for(int i = 0; i < 4; i++) {
					int nextX = currX + dx[i];
					int nextY = currY + dy[i];
					if( isUnit(currX, currY, i) && !visit[nextX][nextY]) {
						visit[nextX][nextY] = true;
						que.add(new int[] {nextX, nextY});
					}
				}
			}
			cnt++;
		}
		return -1;
	}

	private static boolean isUnit(int x, int y, int dir) {
		for(int i = x; i < x + A; i++) {
			for(int j = y; j < y + B; j++) {
				int nextX = i + dx[dir];
				int nextY = j + dy[dir];
				if( nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || map[nextX][nextY]== 1) return false;
			}
		}
		return true;
	}
}
