import java.util.*;
import java.io.*;

class Solution {
	static int[] dx = new int[] {1, -1, 0, 0}; // 상하좌우
	static int[] dy = new int[] {0, 0, 1, -1};
	static int N;
	static int[][] rooms;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			rooms = new int[N][N];
			int maxMoveRoom = 0;
			int maxMoveCount = Integer.MIN_VALUE;

			for(int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x = 0; x < N; x++) {
					rooms[y][x] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < N; x++) {
					int count = dfs(x, y, 1);
					
					if(maxMoveCount < count) {
						maxMoveCount = count;
						maxMoveRoom = rooms[y][x];
					} else if(maxMoveCount == count) {
						maxMoveRoom = Math.min(maxMoveRoom, rooms[y][x]);
					}
				}
			}
			
			System.out.println("#" + tc + " " + maxMoveRoom + " " + maxMoveCount);
		}
	}
	
	public static int dfs(int x, int y, int count) {

		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
				continue;
			}
			
			if(rooms[ny][nx] == rooms[y][x] + 1) {
				count = dfs(nx, ny, count+1);
			}
		}
		
		return count;
	}
}