import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int i = 0;
        for(; i < d.length; i++){
            if(budget >= d[i]) budget -= d[i];
            else break;
        }
        
        return i;
    }
}