import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,1,-1,-1,0,1};

        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] board = new int[n][n];
            board[n/2][n/2] = 2;
            board[n/2-1][n/2-1] = 2;
            board[n/2][n/2-1] = 1;
            board[n/2-1][n/2] = 1;

            for(int i = 0; i<m; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                int color = sc.nextInt();
                board[x][y] = color;

                for(int j = 0; j<8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    boolean valid = false;

                    while(nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] != 0) {
                        if(board[nx][ny] == color) {
                            valid = true;
                            break;
                        }
                        nx += dx[j];
                        ny += dy[j];
                    }

                    if(valid) {
                        int pre_x = x + dx[j];
                        int pre_y = y + dy[j];

                        while(!(pre_x == nx && pre_y == ny)) {
                            board[pre_x][pre_y] = color;
                            pre_x += dx[j];
                            pre_y += dy[j];
                        }
                    }
                }
            }

            int black = 0;
            int white = 0;
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    if(board[i][j] == 1) black++;
                    else if(board[i][j] == 2) white++;
                }
            }

            sb.append("#" + tc + " " + black + " " + white + "\n");
        }
        System.out.println(sb);
    }
}