import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int idx = score.length - 1;
        int nApple = 0;
        int min = k;
        while(true){
            if(nApple == m){
                answer += ( min * m);
                nApple = 0;
            }
            
            if(idx == -1) break;
            
            min = Math.min(min, score[idx--]);
            nApple++;
        }
        
        return answer;
    }
}