import java.util.*;

class Solution {
    static final int MAX = 9;
    public int solution(int N, int number) {
        
        if(N == number) return 1;
        
        int answer = -1;
        
        StringBuilder sb = new StringBuilder();
        Set<Integer>[] dp = new HashSet[MAX];
        for(int i = 0; i < MAX; i++) dp[i] = new HashSet<>();
        
        dp[0].add(0);
        dp[1].add(N);
        sb.append(N);
        
        for(int i = 2; i < MAX; i++){
            // 숫자 연결해서 쓴 경우
            dp[i].add(Integer.parseInt(sb.append(N).toString()));
            
            // 사칙연산으로 만든 경우
            for(int j = 1; j < i; j++){
                for(int n1 : dp[i-j]){
                    for(int n2 : dp[j]){
                        dp[i].add(n1 + n2);
                        dp[i].add(n1 - n2);
                        dp[i].add(n1 * n2);
                        if( n2 != 0 )dp[i].add(n1 / n2);
                    }
                }
            }
            
            if(dp[i].contains(number)){
                answer = i;
                break;
            }
            
        }
        
        return answer;
    }
    
}