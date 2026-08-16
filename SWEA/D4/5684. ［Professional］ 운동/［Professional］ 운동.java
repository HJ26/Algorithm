import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int N, M, ans;
    static int[][] map;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();// (1 ≤ T ≤ 20)
        for (int tc = 1; tc <= T; tc++) {
            // (2 ≤ N ≤ 400, 2 ≤ M ≤ N*(N-1))
            N = sc.nextInt();
            M = sc.nextInt();
            map = new int[N][N];
            for (int i = 0; i < M; i++) {
                map[sc.nextInt() - 1][sc.nextInt() - 1] = sc.nextInt(); // 거리는 10,000 이하의 자연수
            }
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                BFS(i);
            }
            System.out.println("#" + tc + " " + (ans == Integer.MAX_VALUE ? -1 : ans));
        }
    }// end of main

    private static void BFS(int start) {
        boolean visit[] = new boolean[N];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { start, 0 });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < N; i++) {
                if (map[cur[0]][i] != 0 && !visit[i]) {
                    visit[i] = true;
                    q.offer(new int[] { i, cur[1] + map[cur[0]][i] });
                }
                if (map[cur[0]][i] != 0 && i == start) {
                    if (ans > cur[1] + map[cur[0]][i])
                        ans = cur[1] + map[cur[0]][i];
                    return;
                }
            }
        }
    }

}