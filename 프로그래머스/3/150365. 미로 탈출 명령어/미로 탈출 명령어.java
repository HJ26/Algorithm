import java.util.*;

class Solution {
    
    static int N, M, R, C, K;
    static int[] dx = {1, 0, 0, -1}, dy = {0, -1, 1, 0};
    static String route;
    static String[] dirStr = { "d", "l", "r", "u" };
    static boolean isfind = false;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        route = "impossible";

        N = n;
        M = m;
        R = r;
        C = c;
        K = k;
        
        int minDist = Math.abs(R - x) + Math.abs(C - y);
        if( minDist > K || (K - minDist) % 2 != 0 ) return route;
        
        // 깊이우선탐색
        StringBuilder routeTmp = new StringBuilder();
        dfs(x, y, 0, routeTmp);
        
        return route;
    }
    
    public void dfs(int x, int y, int cnt, StringBuilder routeTmp){
        
        if( x == R && y == C && cnt == K ){
            route = routeTmp.toString();
            isfind = true;
            return;
        }
        
        for(int dir = 0; dir < 4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if( nx > N || nx <= 0 || ny > M || ny <= 0 || cnt > K ) continue;
            if( Math.abs(R - nx) + Math.abs(C - ny) > K - cnt) continue;
            routeTmp.append(dirStr[dir]);
            dfs( nx, ny, cnt+1, routeTmp);
            if(isfind) return;
            routeTmp.deleteCharAt(routeTmp.length()-1);
        }
    }
}