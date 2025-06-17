import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : works) pq.add(i);
        
        while(!pq.isEmpty() && n > 0){
            int tmp = pq.poll();
            int diff = (pq.isEmpty() ? n : tmp - pq.peek());
            
            if(n >= diff && diff > 0){
                if(tmp > diff) pq.add(tmp - diff);
                n -= diff;
            }else if(diff == 0){
                if(tmp > 1) pq.add(tmp-1);
                n--;
            }else{
                pq.add(tmp - n);
                n = 0;
            }
        }
        
        while(!pq.isEmpty()) {
            int pqn = pq.poll();
            System.out.print(pqn + " ");
            answer += Math.pow(pqn, 2);
        }
        return answer;
    }
}