import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 물건 정보 입력받기
		int[][] productInfo = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			productInfo[i][0] = Integer.parseInt(st.nextToken());
			productInfo[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// dp
		int[][] dp = new int[N][K+1];
		for(int i = 0; i < N; i++) {
			int weight = productInfo[i][0];
			int value = productInfo[i][1];
			for(int j = 0; j <= K; j++) {
				if( i == 0 ) {
					if( j >= weight) dp[i][j] = value;
				}else {
					if( j >= weight ) dp[i][j] = Math.max(dp[i-1][j-weight] + value, dp[i-1][j]);
					else dp[i][j] = dp[i-1][j];					
				}
			}
		}
		System.out.println(dp[N-1][K]);
	}
}
