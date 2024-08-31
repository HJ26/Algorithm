import java.io.*;
import java.util.*;

public class Main {
	
	static class Problem{
		int deadLine;
		int nCup;
		
		public Problem() {}

		public Problem(int deadLine, int nCup) {
			this.deadLine = deadLine;
			this.nCup = nCup;
		}
		
		@Override
		public String toString() {
			return "Problem [deadLine=" + deadLine + ", nCup=" + nCup + "]";
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int maxDead = 0;
		
		// 문제 정보를 저장할 리스트
		List<Problem> problems = new ArrayList<Main.Problem>();
		
		// 입력값이 없을때까지 받기
		String input;
		while( (input = br.readLine()) != null ) {
			
			st = new StringTokenizer(input);
			int deadTmp = Integer.parseInt(st.nextToken());
			int cupTmp = Integer.parseInt(st.nextToken());
			maxDead = Math.max(maxDead, deadTmp);
			problems.add(new Problem(deadTmp, cupTmp));
			
		};
		
		// 정렬
		Collections.sort(problems, new Comparator<Problem>() {
			@Override
			public int compare(Problem o1, Problem o2) {
				if( o1.deadLine == o2.deadLine ) return o2.nCup - o1.nCup;
				return o2.deadLine - o1.deadLine;
			}
		});
		
		int maxCup = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		// 데드라인을 기준으로 문제 풀기 시작
		Problem curP;
		for(int day = maxDead, idx = 0; day > 0; day-- ) {
			
			// 현재 데드라인 기준 풀 수 있는 문제를 pq에 추가
			while(idx < problems.size()) {
				curP = problems.get(idx);
				if(curP.deadLine < day) break;
				else {
					pq.add(curP.nCup);
					idx++;
				}
			}
			
			// 가장 높은 컵라면 문제 풀기
			if(!pq.isEmpty()) maxCup += pq.poll();
			
		}
		
		// 출력
		System.out.println(maxCup);
	}
}
