import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char cur = s.charAt(i);
            if(!map.containsKey(cur)) answer[i] = -1;
            else answer[i] = i - map.get(cur);
            
            map.put(cur, i);
            
        }
        
        return answer;
    }
}