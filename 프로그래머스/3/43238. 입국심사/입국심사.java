import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        int N = times.length;
        Arrays.sort(times);
        long left = 0;
        long right = times[N-1] * (long)n;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long complete = 0;
            for(int i = 0; i < N; i++ ) complete += mid / times[i];
            if( complete < n ) left = mid + 1;
            else {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        
        return answer;
    }

}