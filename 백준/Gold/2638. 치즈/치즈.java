import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    static int N, M, nCheese, time = 0;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;
    static boolean[][] isAir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isAir = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) nCheese++;
            }
        }

        checkAir(0,0);
        while(true){
            time++;
            removeCheese();
            if(nCheese <= 0) break;
        }

        System.out.println(time);

    }

    private static void checkAir(int r, int c){
        Queue<int[]> que = new LinkedList<>();
        visit = new boolean[N][M];

        que.add(new int[] { r,c });
        visit[r][c] = true;
        isAir[r][c] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int dir = 0; dir < 4; dir++){
                int nr = cur[0] + dr[dir];
                int nc = cur[1] + dc[dir];
                if(!check(nr,nc)) continue;
                if(visit[nr][nc] || map[nr][nc] == 1 || isAir[nr][nc]) continue;

                visit[nr][nc] = true;
                isAir[nr][nc] = true;
                que.add(new int[] { nr, nc });
            }
        }
    }

    private static void removeCheese(){

        Queue<int[]> que = new LinkedList<>();
        Queue<int[]> airTmp = new LinkedList<>();

        // 치즈 확인
        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(map[r][c] == 1) que.add(new int[] { r, c });
            }
        }

        // 공기 확인해서 지우기
        Loop:
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int check = 0;
            for(int dir = 0; dir < 4; dir++){
                int nr = cur[0] + dr[dir];
                int nc = cur[1] + dc[dir];
                if(!check(nr,nc)) continue;

                if(isAir[nr][nc]) check++;
                if(check == 2){
                    airTmp.add(new int[] { cur[0], cur[1] });
                    nCheese--;
                    continue Loop;
                }
            }
        }

        while(!airTmp.isEmpty()){
            int[] cur = airTmp.poll();
            map[cur[0]][cur[1]] = 0;
            checkAir(cur[0], cur[1]);
        }
    }

    private static boolean check(int r, int c){
        if( r < 0 || r >= N || c < 0 || c >= M) return false;
        return true;
    }
}

