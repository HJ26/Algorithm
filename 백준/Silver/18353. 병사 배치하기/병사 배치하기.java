import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] attack = new int[N];
        for(int i = 0; i < N; i++){
            attack[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < N; i++){
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--){
                if(attack[i] >= attack[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(max, dp[i]);
            }
        }
        
        System.out.println(N-max);
    }
}
