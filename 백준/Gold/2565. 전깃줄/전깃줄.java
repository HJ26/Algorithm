import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] dp;
    static int[][] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        lines = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        dp = new int[N];
        int max = 1;
        for(int i = 0; i < N; i++){
            dp[i] = Math.max(recur(i), max);
            max = Math.max(max, dp[i]);
        }


        System.out.println(N-max);

    }

    private static int recur(int idx){
        if(dp[idx] == 0){
            dp[idx] = 1;
            for(int i = idx+1; i < N; i++){
                if(lines[idx][1] < lines[i][1]){
                    dp[idx] = Math.max(dp[idx], recur(i)+1);
                }
            }
        }
        return dp[idx];
    }
}
