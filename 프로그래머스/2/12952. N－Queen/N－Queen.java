import java.util.*;

class Solution {
    static boolean[][] map;
    static int cnt = 0;
    public int solution(int n) {
        
        map = new boolean[n][n];
        nQueen(0, n);
        System.out.println(cnt);
        return cnt;
    }
    
    private void nQueen(int r,int N){
        
        if(r == N){
            cnt++;
            return;
        }
        
        for(int c = 0; c < N; c++){
            map[r][c] = true;
            if(!check(r,c,N)){
                map[r][c] = false;
                continue;
            }
            nQueen(r+1, N);
            map[r][c] = false;
        }
    }
    
    private boolean check(int r, int c, int N){

        // 같은 열에 Queen이 있는경우
        for(int i = 0; i < r; i++){
            if(map[i][c]) return false;
        }
        
        // 대각선에 Queen이 있는경우
        int tmp = 1;
        while(r - tmp >= 0 && c - tmp >= 0 ){
            if(map[r-tmp][c-tmp]) return false;
            tmp++;
        }
        
        tmp = 1;
        while(r - tmp >= 0 && c + tmp < N ){
            if(map[r-tmp][c+tmp]) return false;
            tmp++;
        }
        
        return true;
    }
    
}