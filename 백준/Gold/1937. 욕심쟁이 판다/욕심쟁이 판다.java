import java.io.*;
import java.util.*;

public class Main {

	static boolean[][] visit;
	static int[][] map, placeCnt;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int N, maxCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		placeCnt = new int[N][N];
		visit = new boolean[N][N];
		maxCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				DFS(i, j);
			}
		}
		
		bw.write(Integer.toString(maxCnt));
		bw.close();
		br.close();
	}

	private static void DFS(int curX, int curY) {

		if(placeCnt[curX][curY] != 0) {
			maxCnt = Math.max(maxCnt, placeCnt[curX][curY]);
			return;
		}
		
		placeCnt[curX][curY] =  1;
		
		for(int dir = 0; dir < 4; dir++) {
			int nextX = curX + dx[dir];
			int nextY = curY + dy[dir];
			
			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
			
			if(map[curX][curY] < map[nextX][nextY]) {
				DFS(nextX, nextY);
				placeCnt[curX][curY] = Math.max(placeCnt[curX][curY], placeCnt[nextX][nextY]+1);
			}
		}
		maxCnt = Math.max(maxCnt, placeCnt[curX][curY]);
		
	}

}
