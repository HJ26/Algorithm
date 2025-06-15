import java.util.*;

class Solution {
    static boolean[][] visit;
    static int[][] map;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 }; 
    static int N, M, days = 0;
    static List<Integer> answer;
    
    public List<Integer> solution(String[] maps) {
        answer = new ArrayList<>();
        
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                char tmp = maps[i].charAt(j);
                if(tmp == 'X') map[i][j] = -1;
                else map[i][j] = Character.getNumericValue(tmp);
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visit[i][j] || map[i][j] == -1) continue;
                visit[i][j] = true;
                days = map[i][j];
                findArea(i,j);
                answer.add(days);
                days = 0;
            }
        }
        
        if(answer.isEmpty()) answer.add(-1);
        Collections.sort(answer);
        
        return answer;
    }
    
    private static void findArea(int r, int c){
        for(int dir = 0; dir < 4; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if(map[nr][nc] == -1 || visit[nr][nc]) continue;
            visit[nr][nc] = true;
            days += map[nr][nc];
            findArea(nr, nc);
        }
    } 
}