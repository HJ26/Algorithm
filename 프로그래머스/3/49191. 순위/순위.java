import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] records = new int[n+1][n+1];
        
        for(int i = 0; i < results.length; i++){
            int winner = results[i][0];
            int loser = results[i][1];
            records[winner][loser] = 1;
            records[loser][winner] = -1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(records[i][k] != 0 && records[i][k] == records[k][j]){
                        records[i][j] = records[i][k];
                        records[j][i] = records[i][k] * -1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(records[i][j] != 0) cnt++;
            }
            if(cnt == n-1) answer++;
        }
        
        return answer;
    }
}