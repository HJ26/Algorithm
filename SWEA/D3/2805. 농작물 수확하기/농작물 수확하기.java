import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];

            for(int i = 0; i < n; i++) {
                String line = br.readLine();
                for(int j = 0; j < n ;j++) {
                    board[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }

            int cy = n/2;
            int cx = n/2;
            int sum = board[cy][cx];
            for(int d = 1; d <= n/2; d++) {
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if ((Math.abs(cy -i) + Math.abs(cx - j)) == d) {
                            sum += board[i][j];
                        }
                    }
                }
            }

            sb.append("#"+tc+" "+sum+"\n");
        }
        System.out.print(sb);
    }
}