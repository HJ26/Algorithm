import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int N = commands.length;
        int[] answer = new int[N];
        PriorityQueue<Integer> pq;
        
        for(int n = 0; n < N; n++){
            
            int i = commands[n][0] - 1;
            int j = commands[n][1] - 1;
            int k = commands[n][2] - 1;
            
            pq = new PriorityQueue<>();
            for(int idx = i; idx <= j; idx++) pq.add(array[idx]);
            for(int t = 0; t < k; t++) pq.poll();
            answer[n] = pq.poll();
            
        }
        
        
        
        
        return answer;
    }
}