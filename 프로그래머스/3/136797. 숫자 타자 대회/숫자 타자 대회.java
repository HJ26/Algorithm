import java.util.*;

class Solution {
    
    static final int MAX_NUM = 10;
    
    static int[][] cost;
    static int[][][] dp;
    static int N;
    static String nums;
    
    public int solution(String numbers) {
        int answer = 0;
        
        initCost();
        
        N = numbers.length();
        nums = numbers;
        dp = new int[N][MAX_NUM][MAX_NUM];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < MAX_NUM; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return typing(0, 4, 6);

    }
    
    private int typing(int idx, int left, int right){
        if(idx == N) return 0;
        
        if(dp[idx][left][right] != -1 ) return dp[idx][left][right];
        
        int num = nums.charAt(idx) - '0';
        int ans = Integer.MAX_VALUE;
        
        // 왼손 움직이기
        if(num != right){
            ans = Math.min(typing(idx+1, num, right) + cost[left][num], ans);
        }
        
        // 오른손 움직이기
        if(num != left){
            ans = Math.min(typing(idx+1, left, num) + cost[right][num], ans);
        }
        
        return dp[idx][left][right] = ans;
    }
    
    private void initCost(){
        cost = new int[MAX_NUM][MAX_NUM];
        
        int r1, c1, r2, c2;
        
        for(int i = 0; i < MAX_NUM; i++){
            for(int j = 0; j < MAX_NUM; j++){
                if(i == j){
                    cost[i][j] = 1;
                    continue;
                }
                
                if(i == 0){
                    r1 = 3;
                    c1 = 1;
                }else{
                    r1 = (i-1)/3;
                    c1 = (i-1)%3;
                }
                
                if(j == 0){
                    r2 = 3;
                    c2 = 1;
                }else{
                    r2 = (j-1)/3;
                    c2 = (j-1)%3;
                }
                
                int dr = Math.abs(r1-r2);
                int dc = Math.abs(c1-c2);
                int min = Math.min(dr, dc);
                int max = Math.max(dr, dc);
                int diff = dr + dc;
                
                if(diff == 1) cost[i][j] = 2;
                else if(diff > 1) cost[i][j] = min*3 + (max-min)*2;
                    
            }
        }
    }
}