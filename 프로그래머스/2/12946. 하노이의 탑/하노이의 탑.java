import java.util.*;

class Solution {
    
    static List<int[]> route = new ArrayList<>();
    public List<int[]> solution(int n) {
        
        hanoi(n,1,3,2);
        
        return route;
    }
    
    private void hanoi(int n, int start, int end, int mid){
        if(n == 1){
            route.add(new int[] { start, end });
            return;
        }
        
        hanoi(n-1, start, mid, end);
        route.add(new int[] {start, end});
        hanoi(n-1, mid, end, start);
    }
}