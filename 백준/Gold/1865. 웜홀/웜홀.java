import java.io.*;
import java.util.*;


public class Main {
	
	// 간선 정보 저장할 클래스
	static class Edge{
		int start;
		int end;
		int time;
		
		public Edge() {}

		public Edge(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", time=" + time + "]";
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N, M, W;
		int[] dist;
		boolean isCycle = false;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 정점개수
			M = Integer.parseInt(st.nextToken());	// 도로개수
			W = Integer.parseInt(st.nextToken());	// 웜홀개수
			
			List<Edge> edges = new ArrayList<Main.Edge>();
			
			// dist 배열을 0으로 초기화
			dist = new int[N];
			
			// 음수 가중치의 존재 여부를 보면 되므로 최대값으로 초기화 안해도 됨
			// Arrays.fill(dist, Integer.MAX_VALUE);
			
			// 도로 입력
			for(int i = 0; i < M; i++) {
				
				st = new StringTokenizer(br.readLine());
				int stTmp = Integer.parseInt(st.nextToken())-1;
				int endTmp = Integer.parseInt(st.nextToken())-1;
				int timeTmp = Integer.parseInt(st.nextToken());
				edges.add(new Edge(stTmp, endTmp, timeTmp));
				edges.add(new Edge(endTmp, stTmp, timeTmp));
				
			}
			
			// 웜홀 입력
			for(int i = 0; i < W; i++) {
				
				st = new StringTokenizer(br.readLine());
				int stTmp = Integer.parseInt(st.nextToken())-1;
				int endTmp = Integer.parseInt(st.nextToken())-1;
				int timeTmp = Integer.parseInt(st.nextToken()) * (-1);
				edges.add(new Edge(stTmp, endTmp, timeTmp));
				
			}
			
			isCycle = false;
				
			// 다른 정점에 대하여 반복
			for(int i = 1; i < N; i++) {
				for(Edge edge : edges) {
					if( dist[edge.end] > dist[edge.start] + edge.time ) {
						dist[edge.end] = dist[edge.start] + edge.time;
					}
				}
			}
			
			// 음수 사이클 체크
			for(Edge edge : edges) {
				if( dist[edge.end] > dist[edge.start] + edge.time ) {
					isCycle = true;
					break;
				}
			}
			
			sb.append(isCycle ? "YES" : "NO");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
