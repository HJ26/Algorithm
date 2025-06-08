import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int hIndex = 0;
            
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            hIndex = citations.length - i;
            if(hIndex <= citations[i]) return hIndex;
        }
        
        return 0;
    }
}