import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,K,TIME,goalX,goalY;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0}, dy = { 0, 0, -1, 1};
	static PriorityQueue<Virus> pq = new PriorityQueue<Main.Virus>();
	static class Virus implements Comparable<Virus>{
		int x,y,num,time;
		public Virus() {}
		public Virus(int x, int y, int num,int time) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.time = time;
		}
		@Override
		public int compareTo(Virus o) {
			if(this.time == o.time) {
				return this.num - o.num;
			}
			return this.time - o.time;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					pq.add(new Virus(i,j,map[i][j],0));
				}
				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		TIME = Integer.parseInt(st.nextToken());
		goalX = Integer.parseInt(st.nextToken())-1;
		goalY = Integer.parseInt(st.nextToken())-1;
		
		BFS();

		bw.close();
		br.close();
	}
	private static void BFS() throws IOException {
		
		while(!pq.isEmpty()) {
			Virus cur = pq.poll();
			if(cur.time == TIME) {
				bw.write(Integer.toString(map[goalX][goalY]));
				return;
			}
			for(int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0) continue;
				if(cur.time < TIME && nx == goalX && ny == goalY) {
					bw.write(Integer.toString(cur.num));
					return;					
				}
				map[nx][ny] = cur.num;
				pq.add(new Virus(nx, ny, cur.num, cur.time + 1));
			}
		}
		bw.write(Integer.toString(map[goalX][goalY]));
		
	}
}
