import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = n-1;
        boolean[] prime = new boolean[n+1];
        
        prime[0] = prime[1] = true;
        for(int i = 2; i < Math.sqrt(n); i++){
            if(prime[i]) continue;
            for(int j = i*2; j <= n; j += i){
                if(prime[j]) continue;
                prime[j] = true;
                answer--;
            }
        }
        
        return answer;
    }
}