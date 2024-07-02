import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] graph = new int[1001][1001];
	static int V;
	static int E;
	static boolean[] visited = new boolean[1001];
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int a,b;
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = graph[b][a] = 1;
		}
		
		int result = 0 ;
		
		// dfs 탐색
		for(int i = 1; i <= V; i++) {
			if(visited[i] == false) {
				dfs(i);
				result++;
			}
		}
		
		bw.write(Integer.toString(result));
		bw.close();
		return;
	}
	
	public static void dfs(int index) {
		if(visited[index] == true)
			return;
		else {
			visited[index] = true;
			for(int i = 1; i <= V; i++) {
				if(graph[index][i] == 1) {
					dfs(i);
				}
			}
		}
	}
}