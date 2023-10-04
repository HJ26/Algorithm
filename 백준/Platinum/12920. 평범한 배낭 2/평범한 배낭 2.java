import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 물건 개수
		int M = Integer.parseInt(st.nextToken());	// 최대 무게
		
		List<int[]> productInfo = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());	// 무게
			int value = Integer.parseInt(st.nextToken());	// 가치
			int nProd = Integer.parseInt(st.nextToken());	// 개수
			
			int cnt = 1;
			int tmp;
			while(nProd > 0) {
				tmp = Math.min(cnt, nProd);
				productInfo.add(new int[] {weight * tmp, value*tmp});
				cnt *= 2;
				nProd -= tmp;
			}
			
		}

		int size = productInfo.size();
		int[][] dp = new int[size][M+1];
		for(int i = 0; i < size; i++) {
			int weight = productInfo.get(i)[0];
			int value = productInfo.get(i)[1];
			for(int j = 0; j <= M; j++) {
				if(i == 0) {
					if( j >= weight ) dp[i][j] = value;
				}else {
					if( j >= weight ) dp[i][j] = Math.max(dp[i-1][j-weight] + value, dp[i-1][j]);
					else dp[i][j] = dp[i-1][j];
				}
			}
		}

		bw.write(Integer.toString(dp[size-1][M]));
		bw.close();
		br.close();
	}
}
