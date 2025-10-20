import java.util.*;

class Solution {
    
    public int solution(int[] elements) { 
        
        int len = elements.length;
        int doubleLen = len * 2;
        int[] doubleElements = new int[doubleLen];
        for(int i = 0; i < doubleLen; i++){
            doubleElements[i] = elements[i%len];
        }
        
        // 합 개수 구하기
        Set<Integer> sum = new HashSet<>();
        for(int l = 1; l <= len; l++){
            for(int idx = 0; idx < len; idx++){
                int sumTmp = 0;
                for(int sidx = 0; sidx < l; sidx++){
                    sumTmp += doubleElements[idx+sidx];
                }
                sum.add(sumTmp);
            }

        }
        
        return sum.size();
    }
}