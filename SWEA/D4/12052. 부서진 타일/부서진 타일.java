import java.io.*;
import java.util.*;

public class Solution {
    static int[][] directions = {{1, 0}, {0, 1}, {1, 1}};
    static int N, M;
    static char[][] tiles;

    static boolean replace() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tiles[i][j] == '#') {
                    if (!check(i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static boolean check(int r, int c) {
        tiles[r][c] = '.';

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= N || nc >= M || tiles[nr][nc] == '.') {
                return false;
            }

            tiles[nr][nc] = '.';
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            tiles = new char[N][M];

            for (int i = 0; i < N; i++) {
                tiles[i] = br.readLine().toCharArray();
            }

            sb.append("#"+tc+" ").append(replace() ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}