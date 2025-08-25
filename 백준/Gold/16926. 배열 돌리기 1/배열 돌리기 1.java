import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M, min;
    static int[][] board;
    static int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Math.min(N,M);
        for(int i = 0; i < R; i++) rotation();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void rotation(){

        for(int i = 0; i < min/2; i++){
            int r = i;
            int c = i;

            int tmp = board[r][c];
            int dir = 0;
            while(dir < 4){
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if(nr < N-i && nr >= i && nc < M-i && nc >= i ){
                    board[r][c] = board[nr][nc];
                    r = nr;
                    c = nc;
                }else dir++;
            }
            board[i+1][i] = tmp;
        }

    }
}
