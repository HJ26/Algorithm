import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] nums, tmp;
	static boolean[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 자연수 개수
		M = Integer.parseInt(st.nextToken());	// 수열 길이
		nums = new int[N];
		visit = new boolean[N];
		tmp = new int[M];
		
		// 기본 수 넣기
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(nums);
		
		// 수열 찾기
		combi(0);
		
		// 출력
		bw.close();
		br.close();
		
	}

	private static void combi(int idx) throws IOException {
		
		// 뽑을 개수만큼 뽑았다면
		if(idx == M) {
			// stringbuilder 에 넣고 출력준비하기
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < M; i++) {
				sb.append(tmp[i]).append(" ");
			}
			bw.write(sb.toString());
			bw.write("\n");
			return;
		}
		
		// 아직 안뽑았다면 이어서 뽑기
		int before = 0; // 이전에 내가 본 값
		
		// 처음부터 끝까지 탐색
		for(int i = 0; i < N; i++) {
			
			// 이미 사용한 적 있는 숫자면 넘기기
			// 이전에 사용한 숫자면 넘기기
				// 숫자가 중복으로 들어온 경우 두번째 값은 이미 조합에 다 고려되었으므로 제외
			if(visit[i] || before == nums[i]) continue;
			
			// 사용한 적 없고 이전에 사용한 값과 현재 값이 다르면 탐색
			visit[i] = true;
			tmp[idx] = nums[i];
			before = nums[i];
			combi(idx+1);
			visit[i] = false;
			
		}
		
	}
}
