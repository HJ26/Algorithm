import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] map;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

    static class Place{
        int r;
        int c;
        int k;
        int len;

        public Place(int r, int c, int k, int len){
            this.r = r;
            this.c = c;
            this.k = k;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st;

        st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        K = Integer.parseInt(st[2]);

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = br.readLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs(){

        Queue<Place> que = new LinkedList<>();
        boolean[][][] visit = new boolean[N][M][K+1];
        que.add(new Place(0,0,0, 1));
        visit[0][0][0] = true;

        while(!que.isEmpty()){
            Place cur = que.poll();
            if(cur.r == N-1 && cur.c == M-1) return cur.len;
            
            for(int dir = 0; dir < 4; dir++){
                int nr = cur.r + dr[dir];
                int nc = cur.c + dc[dir];
                if(nr >= N || nr < 0 || nc >= M || nc < 0) continue;

               if(map[nr][nc] == 1 && cur.k < K && !visit[nr][nc][cur.k+1]){
                    if(cur.k == K) continue;
                    visit[nr][nc][cur.k+1] = true;
                    que.add(new Place(nr, nc, cur.k+1, cur.len+1));
                }else if(map[nr][nc] == 0 && !visit[nr][nc][cur.k]){
                    visit[nr][nc][cur.k] = true;
                    que.add(new Place(nr, nc, cur.k, cur.len+1));
                }
            }
        }

        return -1;
    }

}
