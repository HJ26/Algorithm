import java.util.*;
import java.io.*;

public class Main {
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	static boolean visit[][];
	static int map[][];
	static int size[][];

	private static final int INF = Integer.MAX_VALUE / 4;
	static int N, nx, ny;

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int size;


		public Node(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", size=" + size + "]";
		}


		@Override
		public int compareTo(Node o) {
			return size - o.size;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 
		int cnt = 1;

		String tmp = "";
		while( !(tmp = br.readLine()).isEmpty()  ) {
			N = Integer.parseInt(tmp);
			if(N == 0) {
				break;
			}

			map = new int[N][N];
			visit = new boolean[N][N];
			size = new int[N][N];

			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
		
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());	
					size[i][j] = INF;
				}
			}

			BFS(0, 0, map[0][0]);
			sb.append("Problem " + cnt + ": " + size[N-1][N-1]).append('\n');
			cnt++;
		}

		bw.write(sb.toString());
		bw.close();
		br.close();

	}

	private static void BFS(int x, int y, int roopy) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		visit[x][y] = true;
		que.offer(new Node(x, y, roopy));

		while( !que.isEmpty() ) {
	
			Node node = que.poll();

			for(int i=0; i<4; i++) {
				nx = node.x + dx[i];
				ny = node.y + dy[i];

				if( nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny] && size[nx][ny] > (map[nx][ny] + node.size) ) {
					size[nx][ny] = map[nx][ny] + node.size;
					visit[nx][ny] = true;
					que.add( new Node( nx, ny, size[nx][ny] ));
				}

			}
		}

	} 

}
