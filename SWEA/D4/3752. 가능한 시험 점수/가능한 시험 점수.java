import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
		for(int tc = 1; tc <= T; tc++) {
            sb.append("#"+tc+" ");
            int N = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());          
            int[] arr = new int[N];
            int sum = 0;
            
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            
            boolean[] dp = new boolean[sum+1];
            dp[0] = true;
            
               
            for(int i = 0; i < N; i++){
                for(int j = sum; j >= 0; j--){
                    if(dp[j]){
                        dp[j + arr[i]] = true;
                    }
                }
            }
            
            int count = 0;
            for(boolean b : dp){
                if(b) count++;
            }

            sb.append(count+"\n");
		}
        System.out.print(sb);
	}
}