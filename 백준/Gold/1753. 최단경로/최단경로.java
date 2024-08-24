import java.io.*;
import java.util.*;

public class Main {

	static int V, E, K;				// 정점 개수, 간선 개수, 시작지점
	static int[] minWeight;			// 최소 경로를 저장할 배열
	static List<Graph>[] edges;		// 간선 정보를 저장할 리스트 배열
	static PriorityQueue<Graph> route = new PriorityQueue<Main.Graph>();	// 경로를 저장할 큐
	
	// 그래프 정보를 저장할 클래스
	static class Graph implements Comparable<Graph> {
		int start;
		int end;
		int weight;

		public Graph() {}

		public Graph(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
        public int compareTo(Graph o) {
            return Integer.compare(this.weight, o.weight);
        }
		 
		@Override
		public String toString() {
			return "Graph [end=" + end + ", weight=" + weight + "]";
		}

		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine())-1;

		minWeight = new int[V];
		Arrays.fill(minWeight, Integer.MAX_VALUE);	// 초기화
		minWeight[K] = 0;
		
		// 각 점에서 시작하는 경로를 저장할 리스트 배열
		edges = new ArrayList[V];
		for (int i = 0; i < V; i++) {
            edges[i] = new ArrayList<>();
        }
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int stTmp = Integer.parseInt(st.nextToken()) - 1;
			int endTmp = Integer.parseInt(st.nextToken()) - 1;
			int weTmp = Integer.parseInt(st.nextToken());
			edges[stTmp].add(new Graph(endTmp, weTmp));
			
			// 시작점에서 시작하는 경로만 모아두기
			if(stTmp == K) {
				route.add(new Graph(endTmp, weTmp));
			}
		}

		// 경로탐색 시작
		while(!route.isEmpty()) {
			
			Graph curRoute = route.poll();
			
			int curEnd = curRoute.end;
			int curWeight = curRoute.weight;
			
			// 가중치가 최소면 바꾸기
			if(minWeight[curEnd] > curWeight) {
				
				minWeight[curEnd] = curWeight;
			
				// 다음 경로 이동 ( 최소가 갱신되었을때만 탐색하면 됨 )
				// 최소가 갱신되지 않은 경우 이미 최소인 경로가 존재하기 때문
				for( Graph g : edges[curEnd] ) {
					route.add(new Graph(g.end, curWeight + g.weight));
				}
			}
		}
		
		// 출력
		for(int weight : minWeight) {
			if(weight == Integer.MAX_VALUE) sb.append("INF");
			else sb.append(Integer.toString(weight));
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}


	
}
