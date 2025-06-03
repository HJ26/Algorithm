import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        
        int round = enemy.length;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < round; i++){
            int en = enemy[i];
            que.add(en);
            n -= en;
            if(n < 0){
                if(k > 0){
                    if(!que.isEmpty()) n += que.poll();
                    k--;
                }else{
                    return i;
                }
            }
        }
        
        return round;
    }
}