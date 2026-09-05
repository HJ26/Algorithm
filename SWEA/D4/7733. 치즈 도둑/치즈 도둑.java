import java.util.*;
import java.io.*;
 
class Solution {
    static int N;
    static int[][] arr;
    static boolean[][] V;
    static int[][] dires = {{1,0},{0,1},{-1,0},{0,-1}};
 
    static boolean inside(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
 
    static void bfs(int sx, int sy, int day) {
        ArrayDeque<int[]> Q = new ArrayDeque<>();
        Q.offer(new int[]{sx, sy});
        V[sy][sx] = true;
        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            int x = cur[0], y = cur[1];
            for (int[] dire : dires) {
                int nx = x + dire[0], ny = y + dire[1];
                if (inside(nx, ny) && arr[ny][nx] > day && !V[ny][nx]) {
                    Q.offer(new int[]{nx, ny});
                    V[ny][nx] = true;
                }
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
 
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            int answer = 1;
            for (int day = 1; day <= 100; day++) {
                V = new boolean[N][N];
                int count = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] > day && !V[i][j]) {
                            bfs(j, i, day);
                            count++;
                        }
                    }
                }
                answer = Math.max(answer, count);
            }
 
            System.out.println("#" + tc + " " + answer);
        }
    }
}