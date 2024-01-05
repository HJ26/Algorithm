import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 폰켓몬의 종류와 마리수를 저장할 해쉬맵
        Map<Integer, Integer> pkm = new HashMap<Integer, Integer>();
        for(int num : nums) pkm.put(num, pkm.getOrDefault(num,0)+1);
        
        // 맵의 길이가 N/2 보다 크면 최대 개수는 N/2
        // 작으면 최대길이가 맵의 길이
        if(pkm.size() > nums.length/2) answer = nums.length/2;
        else answer = pkm.size();
        
        return answer;
    }
}