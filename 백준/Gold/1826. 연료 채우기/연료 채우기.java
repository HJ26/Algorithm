import java.io.*;
import java.util.*;

public class Main {
	
	static class OilBank{
		int dist;
		int oil;
		
		public OilBank() {}
		public OilBank(int dist, int oil) {
			this.dist = dist;
			this.oil = oil;
		}
		
		@Override
		public String toString() {
			return "OilBank [dist=" + dist + ", oil=" + oil + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		OilBank[] oilBanks = new OilBank[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int distTmp = Integer.parseInt(st.nextToken());
			int oilTmp = Integer.parseInt(st.nextToken());
			oilBanks[i] = new OilBank(distTmp, oilTmp);
		}
		
		// 주유소 정보 정렬
		Arrays.sort(oilBanks, new Comparator<OilBank>() {

			@Override
			public int compare(OilBank o1, OilBank o2) {
				if(o1.dist == o2.dist) return o2.oil - o1.oil;
				return o1.dist - o2.dist;
			}
			
		});

		// 현재 정보
		st = new StringTokenizer(br.readLine());
		int arrival = Integer.parseInt(st.nextToken());
		int curOil = Integer.parseInt(st.nextToken());

		// 이동
		int nOilBank = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		// 주유소 번호
		int idx = 0;
		// 도착지에 도착할 때까지 반복
		while(curOil < arrival) {
			
			// 주유소가 있고, 현재 기름으로 갈 수 있는 주유소일때
			// 우선순위 큐에 기름 넣기
			while( idx < N && oilBanks[idx].dist <= curOil ) {
				pq.add(oilBanks[idx++].oil);
			}
			
			// 도착을 못했는데 갈 수 있는 주유소가 없는 경우
			// -1 출력
			if(pq.isEmpty()) {
				nOilBank = -1;
				break;
			}
			
			// 갈 수 있는 주유소가 있는경우
			// 기름 넣기
			curOil += pq.poll();
			nOilBank++;
		}
		
		// 출력
		System.out.println( nOilBank );
	}
}
