import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N, K, left, right, minDiff, ans;
		int sum, diff;
		
		for(int tc = 0; tc < T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int[] nums = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(nums);
			
			// 이분탐색을 하면서 주어진 숫자와 가까운 수 찾기
			left = 0;
			right = N-1;
			minDiff = Integer.MAX_VALUE;
			ans = 0;
			
			while(left < right) {
				
				sum = nums[left] + nums[right];
				diff = Math.abs(K - sum);
				
				// 차이가 최소차이보다 작으면 갱신
				if(diff <= minDiff) {
					if(diff < minDiff) ans = 0;
					minDiff = diff;
					ans++;
				}
				
				// 합이 K 보다 크면 두 수의 합이 작아져야함
				if( sum >= K ) right--;
				else left++;	// 반대면 두 수의 합이 커져야함
				
 			}
			// 결과 저장
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
