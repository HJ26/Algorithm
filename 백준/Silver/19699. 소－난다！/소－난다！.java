import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] weight, select;

	static boolean[] isPrime = new boolean[9001];
	
	static List<Integer> sumWeight = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 소수판별하기
		// 소수면 F, 아니면 T
		for(int i = 2; i < 9001; i++) {
			if(isPrime[i]) continue;
			for(int j = 2*i; j < 9001; j += i) isPrime[j] = true;
		}
		

		// 기본 정보 입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		
		weight = new int[N];
		select = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		// 확인
		selectCow(0,0);
		
		// 출력
		
		// 소수가 없으면 -1 출력
		if(sumWeight.isEmpty()) sb.append("-1");
		
		// 있으면 오름차순 정렬 후 출력
		else {
			Collections.sort(sumWeight);
			
			int lastW = -1;
			for(int w : sumWeight) {
				
				if(lastW == w) continue; 
				sb.append(w).append(" ");
				lastW = w;
			
			}
		}
		
		System.out.println(sb.toString());
		
	}

	private static void selectCow(int idx, int sidx) {
		
		// 소를 모두 선별했으면 합이 소수인지 확인
		if(sidx == M) {
			int totalWeight = 0;
			for(int w : select) totalWeight += w;
			if(!isPrime[totalWeight]) sumWeight.add(totalWeight);
			return;
		}
		
		// 모든 소를 순회했으면 돌아가기
		if(idx == N) return;
		
		// 선택한 소 정보 저장하고 다음 소 선택
		select[sidx] = weight[idx];
		selectCow(idx+1, sidx+1);	// 현재 소를 선택하고 다음 소를 선택한 경우
		selectCow(idx+1, sidx);		// 현재 소를 선택하지 않고 다음 소를 선택한 경우
		
	}
	
}
