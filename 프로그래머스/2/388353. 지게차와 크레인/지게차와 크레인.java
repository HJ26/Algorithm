import java.util.*;

class Solution {
    
    static Character[][] map;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static int N, M, nContainer;
    
    
    public int solution(String[] storage, String[] requests) {

        N = storage.length;
        M = storage[0].length();
        nContainer = N * M;
        map = new Character[N+2][M+2];
        
        for(int i = 0; i < N+2; i++){
            Arrays.fill(map[i], '-');
        }
        
        for(int i = 1; i <= N; i++){
            String tmp = storage[i-1];
            for(int j = 1; j <= M; j++){
                map[i][j] = tmp.charAt(j-1);
            }
        }
        
        for(String req : requests){
            if(req.length() < 2) forklift(req.charAt(0));
            else crane(req.charAt(0));
        }
        
        return nContainer;
    }
    
    
    private void forklift(Character req){
        
        boolean[][] visit = new boolean[N+2][M+2];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { 0, 0 });
        visit[0][0] = true;
        
        while(!que.isEmpty()){
            
            int[] cur = que.poll();
            
            for(int dir = 0; dir < 4; dir++){
                
                int nr = cur[0] + dr[dir];
                int nc = cur[1] + dc[dir];
                if(nr >= N+2 || nr < 0 || nc >= M+2 || nc < 0 || visit[nr][nc] ) continue;
                
                visit[nr][nc] = true;
                if(map[nr][nc] == '-') que.add(new int[] { nr, nc });
                else if(map[nr][nc] == req) {
                    nContainer--;
                    map[nr][nc] = '-';
                }
            }
        }
    }
    
    private void crane(Character req){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(map[i][j] == req) {
                    nContainer--;
                    map[i][j] = '-';
                }
            }
        }
    }
}