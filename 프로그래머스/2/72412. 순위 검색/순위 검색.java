import java.util.*;

class Solution {
    
    Map<String, List<Integer> > map = new HashMap<>();
    String[] pat = new String[4];
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(String inf : info){
            String[] inp = inf.split(" ");
            setMap(inp,0);
        }
        
        for(List<Integer> set : map.values()) Collections.sort(set);
        
        for(int i = 0; i < query.length; i++){
            String[] que = query[i].split(" ");
            String key = getKey(que);
            answer[i] = count(key, Integer.parseInt(que[que.length-1]));
        }
        
        return answer;
    }
    
    private void setMap(String[] inp, int idx){
        
        if(idx == 4){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 4; i++) sb.append(pat[i]);
            List<Integer> score = map.getOrDefault(sb.toString(), new ArrayList<Integer>());
            score.add(Integer.parseInt(inp[4]));
            map.put(sb.toString(), score);
            return;
        }
        
        
        pat[idx] = inp[idx];
        setMap(inp, idx+1);
        pat[idx] = "-";
        setMap(inp, idx+1);
        
    }
    
    private String getKey(String[] que){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8; i+=2) sb.append(que[i]);
        return sb.toString();
    }
    
    private int count(String key, int score){
        if(!map.containsKey(key)) return 0;
        List<Integer> set = map.get(key);
        
        int left = 0;
        int right = set.size()-1;
        int idx = set.size();
        while(left <= right){
            int mid = (left + right) / 2;
            if(set.get(mid) < score){
                left = mid+1;
            }else{
                idx = Math.min(idx, mid);
                right = mid-1;
            }
        }
        
        return idx == set.size() ? 0 : set.size() - idx;
    }
}