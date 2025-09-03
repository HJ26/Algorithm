import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int R, C, K, cnt = 0;
    static int[] dr = { -1, 1, 0, 0}, dc = { 0,0,1,-1 };
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        R = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);
        K = Integer.parseInt(st[2]);

        map = new int[R][C];
        for(int r = 0; r < R; r++) {
            st = br.readLine().split("");
            for(int c = 0; c < C; c++) {
                map[r][c] = st[c].equals("T") ? -1 : 0;
            }
        }

        map[R-1][0] = -1;
        dfs(R-1, 0, 1);
        
        System.out.println(cnt);

    }

    private static void dfs(int r, int c, int depth) {


        if(depth > K) return;

        if(depth == K && r == 0 && c == C-1) {
            cnt++;
            return;
        }

        for(int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if(map[nr][nc] != 0) continue;

            map[nr][nc] = -1;
            dfs(nr, nc, depth + 1);
            map[nr][nc] = 0;
        }

    }

}
