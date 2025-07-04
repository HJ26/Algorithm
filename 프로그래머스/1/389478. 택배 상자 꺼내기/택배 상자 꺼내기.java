import java.util.*;

class Solution {
    
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < w; i++) map.put(i+1, new ArrayList<>());
        
        int[] idx = new int[w*2];
        for(int i = 0, j = 1; i < w * 2; i++){
            if(i < w) idx[i] = j++;
            else if( i >= w ) idx[i] = --j;
            
        }
        
        int no = 1;
        int col = 0;
        int numNo = 0;
        int numCol = 0;
        while(no <= n){
            if( col == w*2 ) col = 0;
            List<Integer> lst = map.get(idx[col]);
            if(no == num){
                numNo = idx[col];
                numCol = lst.size();
            }
            lst.add(no++);
            map.put(idx[col++], lst);
        }
        
        answer = map.get(numNo).size() - numCol;
        return answer;
    }
}                                                                                                                                               