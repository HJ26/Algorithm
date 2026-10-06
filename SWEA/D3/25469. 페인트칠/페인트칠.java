import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int H = sc.nextInt();
            int W = sc.nextInt();

            int[][] width_first_board = new int[H][W];
            int[][] height_first_board = new int[H][W];

            for (int h = 0; h < H; h++) {
                String line = sc.next();

                for (int w = 0; w < W; w++) {
                    int value = line.charAt(w) == '.' ? 0 : 1;
                    width_first_board[h][w] = value;
                    height_first_board[h][w] = value;
                }
            }

            int width_first_cnt = 0;

            // 가로 방향 칠하기 - 한 줄이 모두 검은색이면 칠하기
            for (int h = 0; h < H; h++) {
                boolean isPaint = true;

                for (int w = 0; w < W; w++) {
                    if (width_first_board[h][w] == 0) {
                        isPaint = false;
                        break;
                    }
                }

                if (isPaint) {
                    for (int w = 0; w < W; w++) {
                        width_first_board[h][w] = 0;
                    }

                    width_first_cnt++;
                }
            }

            // 세로 방향 칠하기 - 한 줄에 검은색이 있으면 칠하기
            for (int w = 0; w < W; w++) {
                for (int h = 0; h < H; h++) {
                    if (width_first_board[h][w] == 1) {
                        width_first_cnt++;
                        break;
                    }
                }
            }

            int height_first_cnt = 0;

            // 세로 방향 칠하기 - 한 줄이 모두 검은색이면 칠하기
            for (int w = 0; w < W; w++) {
                boolean isPaint = true;

                for (int h = 0; h < H; h++) {
                    if (height_first_board[h][w] == 0) {
                        isPaint = false;
                        break;
                    }
                }

                if (isPaint) {
                    for (int h = 0; h < H; h++) {
                        height_first_board[h][w] = 0;
                    }

                    height_first_cnt++;
                }
            }

            // 가로 방향 칠하기 - 한 줄에 검은색이 있으면 칠하기
            for (int h = 0; h < H; h++) {
                for (int w = 0; w < W; w++) {
                    if (height_first_board[h][w] == 1) {
                        height_first_cnt++;
                        break;
                    }
                }
            }

            System.out.println(Math.min(width_first_cnt, height_first_cnt));
        }
    }
}