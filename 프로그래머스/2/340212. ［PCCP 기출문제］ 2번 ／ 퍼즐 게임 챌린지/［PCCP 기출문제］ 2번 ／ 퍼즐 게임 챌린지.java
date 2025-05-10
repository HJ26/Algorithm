class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int min = 1;
        int max = 0;
        for(int i : diffs) max = Math.max(i, max);
        while(min < max){
            int mid = (min + max) / 2;
            if(solve(mid, diffs, times, limit)) max = mid;
            else min = mid+1;
        }
        return max;
    }
    
    public boolean solve(int level, int[] diffs, int[] times, long limit){
        
        long time = (long) times[0];
        for(int i = 1; i < diffs.length; i++){
   
            if(diffs[i] > level){
                time += ((long)diffs[i] - level) * ((long)times[i-1] + (long)times[i]);
            }
            time += (long)times[i];
            if(time > limit) return false;
        }
        
        return true;
    }
}