import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M, total;
    static int[][] map, ocean;
    static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int year = 0;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ocean = new int[N][M];

        total = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) {
                    total++;
                }else{
                    for(int dir = 0; dir < 4; dir++){
                        int nr = i + dr[dir];
                        int nc = j + dc[dir];
                        if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                        ocean[nr][nc]++;
                    }
                }
            }
        }

        while(total != 0){
            year++;
            if(melt()) break;
        }

        year = total == 0 ? 0 : year;
        System.out.println(year);
    }


    private static boolean melt(){

        boolean flag = false;
        Queue<int[]> que = new LinkedList<>();
        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++) {
                if (map[r][c] == 0) continue;
                map[r][c] -= ocean[r][c];
                if(map[r][c] <= 0){
                    flag = true;
                    total--;
                    map[r][c] = 0;
                    que.add(new int[]{r, c});
                }
            }
        }

        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int dir = 0; dir < 4; dir++){
                int nr = cur[0] + dr[dir];
                int nc = cur[1] + dc[dir];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                ocean[nr][nc]++;
            }
        }

        if(flag) return countGroup();
        return false;

    }

    private static boolean countGroup(){

        Queue<int[]> que = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];

        int sum = 0;
        Loop:
        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(map[r][c] != 0){
                    que.add(new int[] { r, c });
                    visit[r][c] = true;
                    sum++;
                    break Loop;
                }
            }
        }

        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int dir = 0; dir < 4; dir++){
                int nr = cur[0] + dr[dir];
                int nc = cur[1] + dc[dir];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc] || map[nr][nc] == 0) continue;

                visit[nr][nc] = true;
                que.add(new int[] {nr, nc});
                sum++;
            }
        }

        return sum < total;
    }
}
