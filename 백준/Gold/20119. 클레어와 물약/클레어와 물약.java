import java.io.*;
import java.util.*;

public class Main {
	
	// 레시피의 재료 개수와 완성 물약을 저장할 클래스
	static class Receipe{
		int indegree;	// 진입차수
		int complete;	// 완성된 물약 번호
		
		public Receipe(int indegree, int complete) {
			this.indegree = indegree;
			this.complete = complete;
		}

		@Override
		public String toString() {
			return "Receipe [complete=" + complete + ", indegree=" + indegree + "]";
		}
		
		
	}
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input;
		
		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// 각 레시피별 정보를 저장할 배열
		Receipe[] receipes = new Receipe[M];
		// 물약별 사용된 레시피 정보를 저장할 리스트 배열
		// ex) 1번 레시피에 2,5 물약이 포함되어 있다면
		//     detailReceipe[2].add(1), detailReceipe[5].add(1)
		List<Integer>[] detailReceipes = new ArrayList[N];
		for(int i = 0; i < N; i++ ) detailReceipes[i] = new ArrayList<Integer>();
		
		// 레시피 정보 저장
		for(int idx = 0; idx < M; idx++) {
			input = br.readLine().split(" ");
			int indegree = Integer.parseInt(input[0]);					// 재료 개수
			int complete = Integer.parseInt(input[input.length-1])-1;	// 완성된 물약 번호
			// ㄴ 번호는 1부터 시작하지만 인덱스는 0부터 시작
			// ㄴ 번호와 인덱스를 매치하기 위해 1 빼주기
			
			// 레시피 정보 저장
			receipes[idx] = new Receipe(indegree, complete);
			
			// 상세레시피 저장
			// 해당 물약이 사용되는 레시피 번호를 저장
			// 즉 입력된 물약번호 --> 재료 --> 해당 재료 인덱스에 현재 레시피 번호(idx)를 저장
			for(int i = 1; i <= indegree; i++) {
				int igd = Integer.parseInt(input[i])-1;	// 인덱스와 물약번호 맞추기
				detailReceipes[igd].add(idx);
			}
		}
		
		// 가지고 있는 물약 개수
		int L = Integer.parseInt(br.readLine());

		// 만들 수 있는 물약 확인 -> T가 만들 수 있는 물약
		boolean[] isMake = new boolean[N];
		int nMake = 0;		// 만들수 있는 물약 개수를 저장할 변수
		
		// 사용할 수 있는 물약 정보를 저장할 큐
		// 큐에서 하나씩 빼서 사용할 예정
		Queue<Integer> que = new LinkedList<Integer>();
		input = br.readLine().split(" ");
		for(int i = 0; i < L; i++) {
			int num = Integer.parseInt(input[i])-1;
			que.add(num);
			isMake[num] = true;
			nMake++;
		}
		
		// 만들 수 있는 물약 확인
		while(!que.isEmpty()) {
			// 현재 재료 물약
			int cur = que.poll();
			
			// idx : 재료가 사용되는 레시피 번호
			for(int idx : detailReceipes[cur]) {
				
				Receipe curR = receipes[idx];	// 현재 확인중인 레시피
				
				// 이 재료를 통해 레시피에 필요한 재료가 0이 되고 (  --curR.indegree == 0 )
				// 아직 만든 적 없는 물약이라면 ( !isMake[curR.complete] )
				if( --curR.indegree == 0 && !isMake[curR.complete] ) {
					que.add(curR.complete);			// 사용가능한 물약에 넣고
					isMake[curR.complete] = true;	// 만들었다고 표시하기
					nMake++;						// 만든 물약 개수 추가
				}
			}
		}
		
		//출력
		sb.append(nMake).append("\n");
		for(int i = 0; i < N; i++) {
			// 번호 맞춰주면서 출력문에 저자
			if(isMake[i]) sb.append(i+1).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
