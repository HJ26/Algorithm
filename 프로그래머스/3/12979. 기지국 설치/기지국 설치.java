class Solution {
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int begin = 1;
        
        for(int idx : stations) {
            if(begin < idx - w)
                answer += search(begin, idx - w - 1, w);
            begin = idx + w + 1;
        }
        
        if(stations[stations.length - 1] + w < n)
            answer += search(stations[stations.length - 1] + w + 1, n, w);
        
        return answer;
    }
    
    private int search(int begin, int end, int w) {
        int res = (end - begin + 1) / (2 * w + 1);
        if((end - begin + 1) % (2 * w + 1) > 0) res++;
        return res;
    }
}