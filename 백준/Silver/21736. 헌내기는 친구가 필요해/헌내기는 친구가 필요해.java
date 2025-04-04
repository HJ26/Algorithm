import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int i_map[][];
    static boolean b_map_visited[][];
    static point doyeon_pos;
    static int d_row[] = { -1, 0, 1, 0 };
    static int d_col[] = { 0, -1, 0, 1 };
    static int person_num = 0;

    static class point {
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s_input[] = br.readLine().split(" ");
        N = Integer.parseInt(s_input[0]);
        M = Integer.parseInt(s_input[1]);

        i_map = new int[N][M];
        b_map_visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s_map_info = br.readLine();

            for (int j = 0; j < M; j++) {
                i_map[i][j] = s_map_info.charAt(j);

                if (i_map[i][j] == 'I')
                    doyeon_pos = new point(i, j);
            }
        }

        Queue<point> q = new LinkedList<>();
        q.add(doyeon_pos);
        b_map_visited[doyeon_pos.x][doyeon_pos.y] = true;

        while (!q.isEmpty()) {
            point now_pos = q.poll();

            if (i_map[now_pos.x][now_pos.y] == 'P') {
                person_num++;
            }

            for (int i = 0; i < 4; i++) {
                int next_x = now_pos.x + d_row[i];
                int next_y = now_pos.y + d_col[i];

                if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= M || b_map_visited[next_x][next_y] == true) {
                    continue;
                }
                if (i_map[next_x][next_y] == 'X') {
                    continue;
                }
                q.add(new point(next_x, next_y));
                b_map_visited[next_x][next_y] = true;
            }
        }

        if (person_num == 0) {
            System.out.println("TT");
        } else
            System.out.println(person_num);

        return;
    }
}