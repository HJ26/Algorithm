import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= TC; t++) {
			int k = Integer.parseInt(br.readLine());
			long[][] dp = new long[k][2];
			
			dp[0][0] = 2;
			dp[0][1] = 1;
			
			for(int i = 1; i < k; i++) {
				dp[i][0] = dp[i-1][0] + dp[i-1][1];
				dp[i][1] = dp[i-1][0];
			}
			
			System.out.println("#" + t + " " + dp[k-1][0] + " " + dp[k-1][1]);
		}
	}
}