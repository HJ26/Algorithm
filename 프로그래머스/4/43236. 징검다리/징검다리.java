import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        // 바위 위치 정렬
        Arrays.sort(rocks);
        
        
        int left = 0;
        int right = distance;
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(removeRocks(mid, rocks, distance) <= n) {
                left = mid + 1;
                answer = mid;
            }else{
                right = mid - 1;
            }
        }
        return answer;
    }
    
    private int removeRocks(int dist, int[] rocks, int distance){
        int before = 0;
        int cnt = 0;
        for(int i = 0; i < rocks.length; i++){
            if( rocks[i] - before < dist){
                cnt++;
                continue;
            }
            
            before = rocks[i];
        }
        
        if(distance - before < dist) cnt++;
        return cnt;
    }
}