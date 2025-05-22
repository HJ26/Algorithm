import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap <String, Integer> m1 = new HashMap<>();
        int size = plays.length;
        
        for(int i=0; i<size; i++){
            String g = genres[i];
            int p = plays[i];
            
            if(m1.containsKey(g)){
                int cnt = m1.get(g);
                m1.put(g, cnt+p);
            }else{
                m1.put(g, p);
            }
        }
        
        ArrayList<Integer> temp = new ArrayList<Integer>();  
        
        List<String> keyList = new ArrayList<>(m1.keySet());
        Collections.sort(keyList, (o1,o2)->(m1.get(o2).compareTo(m1.get(o1))));
        
        for(int i=0; i<keyList.size(); i++){
            String g = keyList.get(i);
            int firstMax = 0;
            int secondMax = 0;
            int firstIdx = -1;
            int secondIdx = -1;
            for(int j=0; j<size; j++){
                if(genres[j].equals(g)){
                    if(firstMax < plays[j]){
                        secondMax = firstMax;
                        firstMax = plays[j];
                        secondIdx = firstIdx;
                        firstIdx = j;
                    }
                    else {
                        if(secondMax < plays[j]){
                            secondMax = plays[j];
                            secondIdx = j;
                        }
                    }
                } 
            }
            if(secondIdx == -1){
                temp.add(firstIdx);
            }else{
                temp.add(firstIdx); 
                temp.add(secondIdx);
            }
        }
        
        int[] answer = new int[temp.size()];
        for(int i=0; i<temp.size(); i++){
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}