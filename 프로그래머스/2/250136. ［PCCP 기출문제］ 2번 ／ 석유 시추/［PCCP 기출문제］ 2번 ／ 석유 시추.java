import java.util.*;

class Solution {
    
    static int[][] visit;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static int N, M, idx = 1;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        N = land.length;
        M = land[0].length;
        visit = new int[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(land[i][j] == 1 && visit[i][j] == 0) findGroup(i,j,land);
            }
        }
        
        answer = findMax();
        
        return answer;
    }
    
    static void findGroup(int r, int c, int[][] land){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { r, c });
        
        int area = 1;
        visit[r][c] = idx;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            for(int dir = 0; dir < 4; dir++){
                
                int nr = cur[0] + dr[dir];
                int nc = cur[1] + dc[dir];
                
                if(nr >= N || nr < 0 || nc >= M || nc < 0) continue;
                if(land[nr][nc] == 0 || visit[nr][nc] != 0 ) continue;
                
                visit[nr][nc] = idx;
                area++;
                que.add(new int[] {nr, nc});
            }
        }
        
        map.put(idx++, area);

    }
    
    private int findMax(){
        
        int max = 0;
        for(int c = 0; c < M; c++){
            
            int sum = 0;
            boolean[] visitGroup = new boolean[map.size()+1];
            
            for(int r = 0; r < N; r++){
                int num = visit[r][c];
                if(num != 0 && !visitGroup[num]) {
                    sum += map.get(num);
                    visitGroup[num] = true;
                }
            }
            max = Math.max(sum, max);
        }
        
        return max;
    }
}