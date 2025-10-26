class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int last = section[0];
        int cnt = 1;
        for(int i = 1; i < section.length; i++){
            if(last + m > section[i]) continue;
            last = section[i];
            cnt++;
        }
        
        return cnt;
    }
}