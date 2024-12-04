import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for(int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());
        
        int[] dp = new int[K+1];
        dp[0] = 1;
        for(int i = 0; i < N; i++){
            for(int k = 1; k <= K; k++){
                if( k >= coins[i] ) dp[k] += dp[k-coins[i]];
            }
        }
        
        System.out.println(dp[K]);
    }
}