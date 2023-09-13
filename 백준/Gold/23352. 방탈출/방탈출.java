import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Room{
	int x;
	int y;
	int move;
	Room(int x, int y, int move){
		this.x = x;
		this.y = y;
		this.move = move;
	}
}
public class Main {
	public static int N, M;
	public static int[][] map;
	public static boolean[][] visit;
	
	public static int start;
	public static int route = 0;
	public static int rslt = 0;
	
	public static int[] dx = { -1, 1, 0, 0};
	public static int[] dy = { 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					visit = new boolean[N][M];
					visit[i][j] = true;
					start = map[i][j];
					BFS(i,j);
				}
			}
		}
		System.out.println(rslt);
	}
	
	public static void BFS(int row, int col) {
		Queue<Room> que = new LinkedList<>();
		que.add(new Room(row, col, 0));
		
		while(!que.isEmpty()) {
			
			Room room = que.poll();
			int x = room.x;
			int y = room.y;
			int move = room.move;
			int end = map[x][y];
			
			if(move >= route) {
				if( move > route) {
					rslt = start+end;
				}else {
					rslt = Math.max(rslt,  start+end);
				}
				route = move;
			}
			
			for(int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if( !visit[nextX][nextY] && map[nextX][nextY] != 0) {
						visit[nextX][nextY] = true;
						que.add(new Room(nextX, nextY, move+1));
					}
				}
			}
		}
		
	}

}
