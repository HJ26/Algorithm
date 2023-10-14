import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] nums = new int[N];
		Map<Integer,List<Integer>> sub = new HashMap<>(); 
		Arrays.setAll(nums, i -> Integer.parseInt(input[i]));
		
		int[][] dp = new int[2][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					if(dp[0][i] < dp[0][j]+1) {
						dp[0][i] = dp[0][j]+1;
						dp[1][i] = j;
					}
				}
			}
		}
		
		int rslt = 0;
		int idx = 0;
		for(int i = 0; i < N; i++) {
			if(rslt < dp[0][i]) {
				rslt = dp[0][i];
				idx = i;
			}
		}
		
		int cnt = 0;
		sb.append(nums[idx]);
		while(cnt++ < rslt) {
			idx = dp[1][idx];
			sb.insert(0," ");
			sb.insert(0,nums[idx]);
		}
		System.out.println(rslt+1);
		System.out.println(sb);
	}
}
