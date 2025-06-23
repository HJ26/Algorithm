import java.util.*;

class Solution {
    
    static boolean[] isUse;
    static int N;
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        
        N = n;
        isUse = new boolean[N+1];
        
        makeCode(1,0,q,ans);
        
        return answer;
    }
    
    
    private void makeCode(int idx, int sidx, int[][] q, int[] ans){
        
        if(sidx == 5){
            if(check(q, ans)) answer++;
            return;
        }
        
        if(idx == N+1) return;
        
        isUse[idx] = true;
        makeCode(idx+1, sidx+1, q, ans);
        isUse[idx] = false;
        makeCode(idx+1, sidx, q, ans);
        
    }
    
    private boolean check(int[][] q, int[] ans){
        
        int[] nContain = new int[ans.length];
        for(int num = 1; num <= N; num++){
            if(!isUse[num]) continue;
            
            for(int idx = 0; idx < ans.length; idx++){
                final int numFinal = num;
                if(Arrays.stream(q[idx]).anyMatch(v -> v == numFinal)) nContain[idx]++;
            }
        }
        
        for(int i = 0; i < ans.length; i++){
            if(nContain[i] != ans[i]) return false;
        }
        
        return true;
        
    }
}