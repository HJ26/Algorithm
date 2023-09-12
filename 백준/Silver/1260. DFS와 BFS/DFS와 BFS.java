import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	static int[][] graph;
	static int node, edge, start;
	static Queue<Integer> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		graph = new int[node+1][node+1];
		visit = new boolean[node+1];
		
		for(int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			graph[vertex1][vertex2] = 1;
			graph[vertex2][vertex1] = 1;
		}
		
		DFS(start);
		sb.append("\n");
		visit = new boolean[node+1];
		BFS(start);
		System.out.println(sb.toString());
	}
	
	// 깊이 우선 탐색
	private static void DFS(int vertex) {
		
		visit[vertex] = true;
		sb.append(vertex).append(" ");
		for(int i = 0; i <= node; i++) {
			if(graph[vertex][i] == 1 && !visit[i]) {
				DFS(i);
			}
		}
	}
	
	// 너비 우선 탐색
	private static void BFS(int vertex) {
		
		que.add(vertex);
		visit[vertex] = true;
		while(!que.isEmpty()) {
			
			vertex = que.poll();
			sb.append(vertex).append(" ");
			for(int i = 1; i <= node; i++) {
				if(graph[vertex][i] == 1 && !visit[i]) {
					que.add(i);
					visit[i] = true;
				}
			}	
		}
		
	}
	
	
}