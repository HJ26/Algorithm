import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static float minCost = 0;
	static Star[] stars;
	static int[] edges, p;

	// 별 정보 클래스
	static class Star{
		float x, y;
		public Star() {}
		public Star(float x, float y) {
			this.x = x;
			this.y = y;
		}
	}
	// 별을 이어주는 선 클래스
	static class Edge implements Comparable<Edge>{
		int x, y;
		float dist;
		public Edge() {}
		public Edge(int x, int y, float dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge o) {
			return Float.compare(this.dist, o.dist);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 데이터 받기
		N = Integer.parseInt(br.readLine());
		stars = new Star[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i] = new Star(Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken()));
		}
		
		// 별들의 간선 구하기
		List<Edge> edges = new LinkedList<Main.Edge>();
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				edges.add(new Edge(i,j,(float) Math.sqrt( Math.pow( (stars[i].x - stars[j].x) , 2) + Math.pow( (stars[i].y - stars[j].y) , 2))));
			}
		}
		
                // 길이가 짧은 순으로 정
		Collections.sort(edges);
		
		// 최소 길이 구하기
		p = new int[N];
		Arrays.setAll(p, i -> i);
		int nEdge = 0;
		for(Edge edge : edges) {
			int fx = findset(edge.x);
			int fy = findset(edge.y);
			if(fx == fy) continue;
			p[fy] = fx;
			minCost += edge.dist;
			nEdge++;
			if(nEdge == N-1 ) break;
		}
	
		// 출력
		System.out.printf("%.2f\n",minCost);
	}
	private static int findset(int x) {
		if(p[x] != x) p[x] = findset(p[x]);
		return p[x];
	}


}
