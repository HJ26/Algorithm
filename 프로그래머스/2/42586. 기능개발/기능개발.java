import java.util.*;

class Solution {
    public List<Integer> solution(int[] p, int[] s) {
        int N = s.length;
        
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        // progress별 걸리는 시간 계산
        for(int i = 0 ; i < N ; i ++){
            int spareProgressVol = 100 - p[i];
            int spareTime = spareProgressVol / s[i];
            
            int res = spareTime;
            
            // 나누어 떨어지지 않을경우
            if(spareProgressVol % s[i] != 0) res += 1;
            
            q.offer(res);
        }
        
        int cnt = 0;
        int lastIdx = q.peek();
        
        while(!q.isEmpty()){
            // 큐의 맨 앞의 값이, 앞의 값보다 작거나 같을 경우
            if(lastIdx >= q.peek()){
                cnt ++;
                q.poll();                
            }
            // 클 경우
            else{
                list.add(cnt);
                lastIdx = q.poll();
                cnt = 1;
            }
        }
        
        list.add(cnt);
        
        return list;
    }
}