import java.io.*;
import java.util.*;


public class Main {
	static int nCity, nEdge, start, end;
	
	static class Edge implements Comparable<Edge>{
		int num, dist;
		public Edge() {}
		public Edge(int to, int dist) {
			this.num = to;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		nCity = Integer.parseInt(br.readLine());
		nEdge = Integer.parseInt(br.readLine());
		List<Edge>[] edges = new ArrayList[nCity];
		for(int i = 0; i < nCity; i++) {
			edges[i] = new ArrayList<Main.Edge>();
		}
		for(int i = 0; i < nEdge; i++) {
			st = new StringTokenizer(br.readLine());
			int from =Integer.parseInt(st.nextToken())-1;
			int to =Integer.parseInt(st.nextToken())-1;
			int dist = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(to, dist));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken())-1;
		end =  Integer.parseInt(st.nextToken())-1;
		
		PriorityQueue<Edge> cost = new PriorityQueue<Edge>();
		for(Edge n : edges[start]) {
			cost.add(new Edge(n.num, n.dist));
		}
		
		boolean[] visit = new boolean[nCity];
		int rslt = 0;
		while(!cost.isEmpty()) {
			Edge curr = cost.poll();
			if(curr.num == end) {
				rslt = curr.dist;
				break;
			}
			for(Edge n : edges[curr.num]) {
				if(visit[n.num]) continue;
				cost.add(new Edge(n.num, curr.dist + n.dist));
			}
			visit[curr.num] = true;
			
		}
		
		System.out.println(rslt);
	}
}
