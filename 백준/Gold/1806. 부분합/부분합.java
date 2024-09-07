import java.io.*;
import java.util.*;

public class Main {
	
	static int N, S;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		nums = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;	// 최소길이
		int left = 0;					// 시작점
		int right = 0;					// 종료점
		int sum = 0;					// 구간합
		
		// 좌우가 맨 끝에 도달하기 전까지
		while(left <= N && right <= N)  {
			
			// 합에 따라 시작, 종료점 변경
			if(sum < S ) sum += nums[right++];	// 합이 기준점보다 작으면 종료점을 더 길게
			else {	// 합이 기준점보다 크면 
				min = Math.min(min, right - left);	// 최소 길이 업데이트
				sum -= nums[left++];				// 시작점을 앞으로
				
			}
		}
		
		// 최소길이가 변경되지 않으면 기준합을 못 넘기므로 0 출력
		// 최소길이가 변경된 적 있으면 길이 출력
		System.out.println(min==Integer.MAX_VALUE ? 0 : min);
	}
}
