import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int N = 5;
    static int[][] bingo = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        L1: for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                cnt++;
                int target = Integer.parseInt(st.nextToken());

                isContainsTarget(target);

                if(checkBingo()) break L1;

            }
        }

        System.out.println(cnt);


    }

    private static void isContainsTarget(int target) {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(bingo[i][j] == target){
                    bingo[i][j] = 0;
                }
            }
        }
    }

    private static boolean checkBingo(){

        int cnt = 0;

        // 가로
        R1: for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(bingo[i][j] != 0) continue R1;
            }
            cnt++;
        }

        if(cnt >= 3) return true;

        // 세로
        C1: for(int j = 0; j < N; j++){
            for(int i = 0; i < N; i++){
                if(bingo[i][j] != 0) continue C1;
            }
            cnt++;
        }

        if(cnt >= 3) return true;

        // 우측 대각선 아래
        boolean flag = true;
        for(int i = 0; i < N; i++){
            if(bingo[i][i] != 0) {
                flag = false;
                break;
            }
        }
        if(flag) cnt++;

        if(cnt >= 3) return true;

        // 좌측 대각선 아래
        flag = true;
        for(int i = 0; i < N; i++){
            if(bingo[i][4-i] != 0) {
                flag = false;
                break;
            }
        }
        if(flag) cnt++;

        if(cnt >= 3) return true;

        return false;
    }

}
