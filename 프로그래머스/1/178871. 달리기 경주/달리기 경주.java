import java.util.*;

class Solution {
    
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String, Integer> rank = new HashMap<>();
        Map<Integer, String> rank2 = new HashMap<>();
        
        int idx = 1;
        for(String name : players){
            rank.put(name, idx);
            rank2.put(idx++, name);
        }
        
        for(String name : callings){
            int rankTmp = rank.get(name);
            String nameTmp = rank2.get(rankTmp-1);
            
            rank.put(name, rankTmp-1);
            rank.put(nameTmp, rankTmp);
            rank2.put(rankTmp-1, name);
            rank2.put(rankTmp, nameTmp);
            
        }
        
        for(Integer no : rank2.keySet()){
            answer[no-1] =  rank2.get(no);
        }
        return answer;
    }
}