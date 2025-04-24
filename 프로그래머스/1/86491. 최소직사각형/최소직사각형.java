import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxWeight = 0;
        int maxHeight = 0;
        for(int i = 0; i < sizes.length; i++){
            for(int j = 0; j < sizes[0].length; j++){
                int wgt = Math.max(sizes[i][0], sizes[i][1]);
                int hgt = Math.min(sizes[i][0], sizes[i][1]);
                maxWeight = Math.max(maxWeight, wgt);
                maxHeight = Math.max(maxHeight, hgt);
            }
        }
        return maxWeight * maxHeight;
    }
}