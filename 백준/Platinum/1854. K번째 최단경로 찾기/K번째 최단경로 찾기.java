import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static PriorityQueue<Integer>[] dist;		// 도시별 가중치
	static List<City>[] edges;					// 간선 정보 저장
	
	// 각 도시와 비용을 저장할 클래스
	static class City implements Comparable<City>{
		
		int v, dist;
		
		public City() {}
		public City(String v, String dist) {
			this.v = Integer.parseInt(v)-1;
			this.dist = Integer.parseInt(dist);
		}
		
		public City(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(City o) {
			return this.dist - o.dist;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 도시개수
		M = Integer.parseInt(st.nextToken());	// 간선개수
		K = Integer.parseInt(st.nextToken());	// 최단 순서
		
		dist = new PriorityQueue[N];	
		edges = new List[N];
		
		for(int i = 0; i <N; i++) {			// 초기화
			edges[i] = new ArrayList();
			dist[i] = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
		}
		
		// 간선 정보 저장
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[Integer.parseInt(st.nextToken())-1].add(new City(st.nextToken(),st.nextToken()));
		}
		
		// 최단거리 구하기
		dij();
		
		// 출력
		for(int i = 0; i < N; i++) {
			// 길이가 K 보다 적으면 -1 출력
			if(dist[i].size() < K) sb.append(-1).append("\n");
			else {
				sb.append(dist[i].peek()).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.close();
	}


	private static void dij() {
		
		// 최단거리
		PriorityQueue<City> pq = new PriorityQueue<>();
		
		// 시작점 정보 저장
		pq.add(new City(0,0));
		dist[0].add(0);
		
		while(!pq.isEmpty()) {
			// 현재 도시
			City curr = pq.poll();
			
			// 도시와 연결되어 있는 도시들 확인
			for(City city : edges[curr.v]) {
				// 도착했을 때 가중치
				int cityDist = curr.dist + city.dist;
				// 가중치의 개수가 K개 이하면 그냥 가중치 리스트에 저장
				if(dist[city.v].size() < K) {
					dist[city.v].add(cityDist);
					pq.add(new City(city.v, cityDist));		// 현재 최단거리 큐에 저장
				}else if(dist[city.v].peek() > cityDist) {	// 가중치의 개수가 K 개 이상이고 현재 최대값보다 가중치가 작으면
					dist[city.v].poll();					// 길이를 유지하기 위해 가장 큰 값 빼기
					dist[city.v].add(cityDist);				// 가중치 배열에 저장
					pq.add(new City(city.v, cityDist));		// 현재 최단거리 큐에 저장
				}
			}
		}
	}
}
