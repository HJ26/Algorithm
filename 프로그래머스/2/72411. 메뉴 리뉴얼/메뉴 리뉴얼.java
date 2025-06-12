import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    static Map<Integer, Integer> max = new HashMap<>();
    static char[] tmp;
    static StringBuilder sb;
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(String str : orders){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            for(int len : course){
                if(!max.containsKey(len)) max.put(len, 0);
                tmp = new char[len];
                combi(chars, 0, 0);
            }
        }
        
        for(String key : map.keySet()){
            if(map.get(key) >= 2 && map.get(key) == max.get(key.length())) answer.add(key);
        }
        
        Collections.sort(answer);
        return answer;
    }
    
    private static void combi(char[] chars, int idx, int sidx){
        if( sidx == tmp.length ){
            StringBuilder sb = new StringBuilder();
            for(char c : tmp) sb.append(String.valueOf(c));
            String tmpStr = sb.toString();
            map.put(tmpStr, map.getOrDefault(tmpStr, 0)+1);
            max.put(tmp.length, Math.max(max.get(tmp.length), map.get(tmpStr)));
            return;
        }
        
        if( idx == chars.length ) return;
        
        tmp[sidx] = chars[idx];
        combi(chars, idx+1, sidx+1);
        combi(chars, idx+1, sidx);
    }
}