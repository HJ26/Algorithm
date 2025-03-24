import java.util.*;
import java.io.*;

public class Main {
	public static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		int[][] map = new int[n][m];
		int[][] visit = new int[n][m];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		Queue<Node> q = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
				map[i][j] = map[i][j] == 1 ? 0 : 1;
				if(map[i][j] == 0) {
					visit[i][j] = 1;
					q.add(new Node(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 1 && visit[nx][ny] == 0) {
					visit[nx][ny] = visit[node.x][node.y] + 1;
					q.add(new Node(nx, ny));
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(visit[i][j] - 1 + " ");
			}
			System.out.println();
		}
	}
}