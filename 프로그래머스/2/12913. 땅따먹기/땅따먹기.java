class Solution {
    
    static final int COL = 4;
    
    int solution(int[][] land) {
        
        int N = land.length;
        int[][] dp = new int[N][COL];
        
        for(int c = 0; c < COL; c++) dp[0][c] = land[0][c];
        
        for(int r = 1; r < N; r++){
            for(int c = 0; c < COL; c++){
                int maxPrev = 0;
                for(int pc = 0; pc < COL; pc++){
                    if(pc == c) continue;
                    maxPrev = Math.max(maxPrev, dp[r-1][pc]);
                }
                
                dp[r][c] = land[r][c] + maxPrev;
            }
        }
        
        
        int answer = 0;
        for(int c = 0; c < COL; c++) answer = Math.max(answer, dp[N-1][c]);
        return answer;
    }
}