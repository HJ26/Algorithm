import java.util.*;

class Solution {
    static int cnt = 0;
    public int solution(int[] number) {
        
        Arrays.sort(number);
        
        makeThreeGroup(0, 0, 0, number);
        
        return cnt;
    }
    
    private void makeThreeGroup(int idx, int sidx, int sum, int[] number){
        
        if(sidx == 3){
            if(sum == 0) cnt++;
            return;
        }
        
        if(idx == number.length) return;
        
        makeThreeGroup(idx+1, sidx+1, sum + number[idx], number);
        makeThreeGroup(idx+1, sidx, sum, number);
    }
}