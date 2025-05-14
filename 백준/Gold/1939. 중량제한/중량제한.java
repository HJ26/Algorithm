import java.io.*;
import java.util.*;

public class Main {
	
	static int start, end, N;
	static List<Bridge>[] bridges;
	
	static class Bridge{
		int to;
		int weight;
		
		public Bridge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		bridges = new ArrayList[N];
		for(int i = 0; i < N; i++) bridges[i] = new ArrayList<Bridge>();
		
		int min = 0;
		int max = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int city1 =  Integer.parseInt(st.nextToken()) - 1;
			int city2 = Integer.parseInt(st.nextToken()) - 1;
			int wgt = Integer.parseInt(st.nextToken());
			
			bridges[city1].add(new Bridge(city2, wgt));
			bridges[city2].add(new Bridge(city1, wgt));
			max = Math.max(max, wgt);
			
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken())-1;
		end = Integer.parseInt(st.nextToken())-1;
		
		int answer = 0;
		while(min <= max) {
			int mid = min / 2 + max / 2;
			if(isArrive(mid)) {
				answer = Math.max(answer, mid);
				min = mid + 1;
			}
			else max = mid - 1;
		}
		
		System.out.println(answer);
	}

	private static boolean isArrive(int mid) {
		
		boolean[] visit = new boolean[N];
		Queue<Integer> que = new LinkedList<Integer>();
		visit[start] = true;
		que.add(start);
		
		while(!que.isEmpty()) {
			int to = que.poll();
			if(to == end) return true;
			
			for(Bridge bri : bridges[to]) {
				if(visit[bri.to] || bri.weight < mid) continue;
				que.add(bri.to);
                visit[bri.to] = true;
			}
		}
		return false;
	}
}
