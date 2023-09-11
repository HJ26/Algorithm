import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato{
	int x;
	int y;
	int z;
	
	tomato(int z, int x, int y){
		this.z = z;
		this.x = x;
		this.y = y;
	}
	
}
public class Main {
	static int M;
	static int N;
	static int H;
	
	static int[] dx = { -1, 0, 1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	
	static int[][][] board;
	static Queue<tomato> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[H][N][M];
		que = new LinkedList<tomato>();
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					if(board[i][j][k] == 1) que.add(new tomato(i,j,k));
				}
			}
		}
		System.out.println(BFS());
	}
	
	public static int BFS() {
		while(!que.isEmpty()) {
			
			tomato t = que.poll();
			int z = t.z;
			int x = t.x;
			int y = t.y;
			
			for(int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				
				if(nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
					if(board[nz][nx][ny] == 0) {
						que.add(new tomato(nz,nx,ny));
						board[nz][nx][ny] = board[z][x][y] + 1;
					}
				}
			}
		}
		
		int rslt = Integer.MIN_VALUE;
		for(int i = 0; i < H; i++) {
			for(int j =0 ; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(board[i][j][k] == 0) return -1;
					rslt = Math.max(rslt,  board[i][j][k]);
				}
			}
		}
		if(rslt == 1) return 0;
		else return rslt-1;
	}
}
