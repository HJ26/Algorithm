import java.util.*;

class Solution {
    
    static int N, M, answer = 0;
    static char[][] map;
    static boolean isRemove = true;
    static int[] dr = { 1, 0, 1 }, dc = { 0, 1, 1};
    
    public int solution(int m, int n, String[] board) {
        
        N = m;
        M = n;
        map = new char[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while(isRemove){
            removeSquare();
            move();
            
        }
        
        return answer;
    }
    
    static void removeSquare(){
    
        boolean[][] visit = new boolean[N][M];
        isRemove = false;
        
        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < M-1; j++){
                
                char target = map[i][j];
                if(target == '-') continue;
                if(target == map[i+1][j] && target == map[i][j+1] && target == map[i+1][j+1]){
                    visit[i  ][j  ] = true;
                    visit[i+1][j  ] = true;
                    visit[i  ][j+1] = true;
                    visit[i+1][j+1] = true;
                    isRemove = true;
                }
                
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visit[i][j]){
                    map[i][j] = '-';
                    answer++;
                }
            }
        }
        
    }
    
    
    static void move(){
        
        for(int j = 0; j < M; j++){
            int r = N-1;
            for(int i = N-1; i >= 0; i--){
                if(map[i][j] == '-'){
                    r = i;
                    while(r >= 0 && map[r][j] == '-'){
                        r--;
                    }
                    
                    if( r < 0 ) r = 0;
                    if(map[r][j] != '-'){
                        map[i][j] = map[r][j];
                        map[r][j] = '-';
                    }
                }
            }
        }
       
    }
}