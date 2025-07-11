import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        
        int N = scores.length;
        List<int[]> info = new ArrayList<>();
        for(int i = 0; i < N; i++) info.add(new int[] { i, scores[i][0] + scores[i][1]});
        
        Collections.sort(info, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[1] - o1[1];
            }
        });
        
        for(int i = 0; i < N; i++){
            int id1 = info.get(i)[0];
            if(id1 == 0) break;
            for(int j = i+1; j < N; j++){
                int id2 = info.get(j)[0];
                if(scores[id1][0] > scores[id2][0] && scores[id1][1] > scores[id2][1]) {
                    info.get(j)[1] = -1;
                    if(id2 == 0) return -1;
                }
                if(id2 == 0) break;
            }
        }
        
        Collections.sort(info, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[1] - o1[1];
            }
        });
        
        int rank = 1;
        int same = 1;
        
        if(info.get(0)[0] == 0) return rank;
        
        for(int i = 1; i < N; i++){
            if(info.get(i)[1] == info.get(i-1)[1]) same++;
            else {
                rank += same;
                same = 1;
            };
            
            if(info.get(i)[0] == 0) return rank;
        }
        return rank;
    }
}