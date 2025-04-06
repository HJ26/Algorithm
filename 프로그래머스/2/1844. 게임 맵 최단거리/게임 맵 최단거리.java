import java.io.*;
import java.util.*;

class Solution {
    
    static int[] dr = { 1, -1, 0, 0}, dc = { 0, 0, 1, -1};
    static boolean[][] visit;
    static int N, M, minDist = Integer.MAX_VALUE;
    
    static class Point{
        int r, c, dist;
        Point(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    
    public int solution(int[][] maps) {
        
        N = maps.length;
        M = maps[0].length;
        visit = new boolean[N][M];
        
        bfs(maps);
        return (minDist == Integer.MAX_VALUE ? -1 : minDist) ;
    
    }
    
    private void bfs(int[][] maps){
        Queue<Point> que = new LinkedList<Point>();
        que.add(new Point(0,0,1));
        visit[0][0] = true;
        
        while(!que.isEmpty()){
            
            Point cur = que.poll();
            int curR = cur.r;
            int curC = cur.c;
            int curDist = cur.dist;
        
            for(int dir = 0; dir < 4; dir++){
            
                if(curR == N-1 && curC == M-1) {
                    minDist = Math.min(minDist, curDist);
                    return;
                }

                int nextR = curR + dr[dir];
                int nextC = curC + dc[dir];

                if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M || maps[nextR][nextC] == 0 || visit[nextR][nextC]) continue;
                que.add(new Point(nextR, nextC, curDist + 1));
                visit[nextR][nextC] = true;
            
            }
        }
        
    }
}