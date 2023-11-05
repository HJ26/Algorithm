import java.io.*;
import java.util.*;

public class Main {

	// 집합 정보를 저장할 배열
	static int[] p;

	// 행성 위치 저장할 클래스
	static class Planet {
		int num, x, y, z;

		public Planet() {}

		public Planet(int num, String[] input) {
			this.num = num;
			this.x = Integer.parseInt(input[0]);
			this.y = Integer.parseInt(input[1]);
			this.z = Integer.parseInt(input[2]);
		}

	}

	// 간선 정보 저장할 클래스
	static class Edge implements Comparable<Edge> {
		int to, from, cost;

		public Edge() {
		}

		public Edge(int to, int from, int cost) {
			this.to = to;
			this.from = from;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}		

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 행성 정보 저장
		int N = Integer.parseInt(br.readLine());
		Planet[] place = new Planet[N];
		for(int i = 0; i < N; i++) {
			place[i] = new Planet(i, br.readLine().split(" "));
		}
		
		// 간선 정보 저장
		List<Edge> edges = new ArrayList<>();
		
		// x 좌표 기준 정렬
		Arrays.sort(place, new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				return o1.x-o2.x;
			}
		});
		
		// 인접한 행성끼리의 간선 정보 구하기 ( 인접해있지 않으면 어짜피 멀어서 연결할 필요 없으니까 간선 추가 안해도 됨
		for(int i = 0; i < N-1; i++) {
			edges.add(new Edge(place[i].num,place[i+1].num,Math.abs(place[i].x-place[i+1].x)));
			
		}
		
		
		// y 좌표 기준 정렬
		Arrays.sort(place, new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				return o1.y-o2.y;
			}
		});
		
		// 인접한 행성끼리의 간선 정보 구하기
		for(int i = 0; i < N-1; i++) {
			edges.add(new Edge(place[i].num,place[i+1].num,Math.abs(place[i].y-place[i+1].y)));
			
		}
		
		// z 좌표 기준 정렬
		Arrays.sort(place, new Comparator<Planet>() {
			@Override
			public int compare(Planet o1, Planet o2) {
				return o1.z-o2.z;
			}
		});
		
		// 인접한 행성끼리의 간선 정보 구하기
		for(int i = 0; i < N-1; i++) {
			edges.add(new Edge(place[i].num,place[i+1].num,Math.abs(place[i].z-place[i+1].z)));
			
		}
		
		// 가중치가 낮은 순서대로 정렬
		Collections.sort(edges);

		
		// 최소스패닝트리 뽑기
		p = new int[N];
		Arrays.setAll(p,(idx)->idx);

		// 최종 비용
		int totalCost = 0;
		// 간선 개수
		int nEdge = 0;
		// 간선 정보들을 순서대로 가져옴
		for(Edge cur : edges) {
			// 두 행성이 포함되어 있는 집합이 어디인지 구하기
			int fx = findset(cur.to);
			int fy = findset(cur.from);
			// 연결이 안되어있으면
			if(fx != fy) {
				p[fy] = p[fx];			// 연결하고
				totalCost += cur.cost;	// 비용추가하고
				nEdge++;				// 간선개수도 추가
				if(nEdge == N-1) break;	// 간선개수가 행성개수-1이면 다 연결되었으므로 동료
			}
		}
		
		// 다 연결 못한채로 끝났으면
		if(nEdge != N-1) totalCost = -1;	// -1 로 바꾸고
		bw.write(Integer.toString(totalCost));	// 비용 출력
		bw.close();
		br.close();
	}

	// 집합 이어주면서 찾기
	private static int findset(int to) {
		if (p[to] != to) p[to] = findset(p[to]);
		return p[to];
	}

}
