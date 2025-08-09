import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] tmp = br.readLine().split(" ");
        nums = new int[N];
        Arrays.setAll(nums, idx -> Integer.parseInt(tmp[idx]));

        dp = new int[N];
        Arrays.fill(dp, -1);
        for(int i = 0; i < N; i++) LIS(i);

        int max = 1;
        for(int i = 0; i < N; i++) max = Math.max(max, dp[i]);

        System.out.println(max);
    }


    private static int LIS(int idx){

        if(dp[idx] == -1){

            dp[idx] = 1;
            for(int i = idx-1; i >= 0; i--){
                if(nums[idx] > nums[i]){
                    dp[idx] = Math.max(dp[idx], LIS(i)+1);
                }
            }

        }

        return dp[idx];

    }
}
