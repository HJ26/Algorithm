import java.io.*;
import java.util.*;

public class Solution {

	static int N,r,c;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T ; tc++) {
			sb.append("#"+tc+" ");
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ArrayList<int[]> list = new ArrayList<int[]>();
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(arr[i][j] != 0 && !visited[i][j]) {
						r = 1;
						c = 1;
						go(i,j,i,j);
						list.add(new int[] {r,c});
					}
				}
			}
			
			Collections.sort(list, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0]*o1[1] == o2[0]*o2[1]) {
						return o1[0] - o2[0];
					}
					return o1[0]*o1[1] - o2[0]*o2[1];
				}
			});
			
			sb.append(list.size()+" ");
			
			for(int[] l: list) {
				sb.append(l[0]+" "+l[1]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}

	static int[] dr = {1,0};
	static int[] dc = {0,1};
	private static void go(int sr, int sc, int i, int j) {
		
		visited[i][j] = true;
		
		for(int d = 0 ; d < 2 ; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr < N && nc < N && arr[nr][nc] != 0 && !visited[nr][nc]) {
				r = Math.max(r, nr - sr + 1);
				c = Math.max(c, nc - sc + 1);
				go(sr, sc, nr, nc);
			}
		}
	}
}