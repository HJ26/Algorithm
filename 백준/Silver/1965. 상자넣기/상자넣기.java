import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] input = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.print(answer);
    }
}