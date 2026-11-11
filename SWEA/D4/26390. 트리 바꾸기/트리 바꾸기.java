import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		
        while(tc-- > 0){
            int N = Integer.parseInt(br.readLine());
            int[] degree = new int[N + 1];

            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                degree[u]++;
                degree[v]++;
            }

            long answer = 0;
            for (int i = 1; i <= N; i++) {
                if (degree[i] > 2) {
                    answer += degree[i] - 2;
                }
            }

            sb.append(answer+"\n");
        }
        System.out.print(sb);
	}
}