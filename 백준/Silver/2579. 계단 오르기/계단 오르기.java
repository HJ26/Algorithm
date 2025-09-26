import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] stair, score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stair = new int[N];
        score = new int[N];

        for(int i = 0; i < N; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        try {
            score[0] = stair[0];
            score[1] = stair[0] + stair[1];
            score[2] = Math.max(stair[0], stair[1]) + stair[2];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(score[N-1]);
            return;
        }
        
        for(int i = 3; i < N; i++){
            score[i] = Math.max(score[i-3] + stair[i-1], score[i-2]) + stair[i];
        }

        System.out.println(score[N-1]);
    }
}
