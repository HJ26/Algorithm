import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] score, totalScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        score = new int[N][3];
        totalScore = new int[N][3];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        totalScore[0][0] = score[0][0];
        totalScore[0][1] = score[0][1];
        totalScore[0][2] = score[0][2];

        for(int i = 1; i < N; i++){
            totalScore[i][0] = Math.min(totalScore[i-1][1],  totalScore[i-1][2]) + score[i][0];
            totalScore[i][1] = Math.min(totalScore[i-1][0],  totalScore[i-1][2]) + score[i][1];
            totalScore[i][2] = Math.min(totalScore[i-1][0],  totalScore[i-1][1]) + score[i][2];
        }

        System.out.println(Math.min(Math.min(totalScore[N-1][0], totalScore[N-1][1]), totalScore[N-1][2]));
    }
}
