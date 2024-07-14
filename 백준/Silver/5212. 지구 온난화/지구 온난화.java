import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] graph;
    static int count;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        
        int up = R;
        int down = 0;
        int left = C;
        int right = 0;

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'X') {
                    count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                            if (graph[nx][ny] == '.') {
                                count++;
                            }
                        } else {
                            count++;
                        }
                    }
                    if (count >= 3) {
                        graph[i][j] = 'S';
                    }
                }
                if (graph[i][j] == 'X') {
                    up = Math.min(up, i);
                    down = Math.max(down, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }

        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                char c = graph[i][j];
                if (c == 'X') {
                    bw.write(c);
                } else {
                    bw.write('.');
                }
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}