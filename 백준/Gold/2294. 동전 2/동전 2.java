import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, K, INF = Integer.MAX_VALUE;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        Set<Integer> coins = new HashSet<>();
        for(int i = 0; i < N; i++){
            coins.add(Integer.parseInt(br.readLine()));
        }

        sum = new int[K+1];
        Arrays.fill(sum, INF);
        sum[0] = 0;

        for(int i = 1; i <= K; i++){
            for(int c : coins){
                if( i-c >= 0 && sum[i-c] != INF) sum[i] = Math.min(sum[i], sum[i-c]+1);
            }
        }

        System.out.println(sum[K] == INF ? -1 : sum[K]);
    }
}
