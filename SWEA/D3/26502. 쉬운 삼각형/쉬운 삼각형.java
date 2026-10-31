import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int max = 0;
            int[][] board = new int[n][2];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                board[i][0] = Integer.parseInt(st.nextToken());
                board[i][1] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++) {
                int ax = board[i][0], ay = board[i][1];
                for (int j = i + 1; j < n; j++) {
                    int bx = board[j][0], by = board[j][1];
                    for (int k = j + 1; k < n; k++) {
                        int cx = board[k][0], cy = board[k][1];
                        if (ax == bx) {
                            if (ay == cy) {
                                max = Math.max(Math.abs(ay - by) * Math.abs(ax - cx), max);
                            } else if (by == cy) {
                                max = Math.max(max, Math.abs(ay - by) * Math.abs(bx - cx));
                            }
                        } else if (ax == cx) {
                            if (ay == by) {
                                max = Math.max(max, Math.abs(ay - cy) * Math.abs(ax - bx));
                            } else if (cy == by) {
                                max = Math.max(max, Math.abs(ay - cy) * Math.abs(cx - bx));
                            }
                        } else if (bx == cx) {
                            if (by == ay) {
                                max = Math.max(max, Math.abs(by - cy) * Math.abs(bx - ax));
                            } else if (cy == ay) {
                                max = Math.max(max, Math.abs(by - cy) * Math.abs(cx - ax));
                            }
                        }
                    }
                }
            }
            sb.append(max+"\n");
        }
        System.out.print(sb);
    }
}