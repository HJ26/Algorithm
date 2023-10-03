import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int nCoin = Integer.parseInt(br.readLine());
			int[] coins = new int[nCoin];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < nCoin; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			int goal = Integer.parseInt(br.readLine());
			
			// 만들 수 있는 최대 개수
			int nCombi = (int) Math.pow(2, 31);
			int[] dp = new int[goal+1];
			
			// 동전 조합 만들기
			for(int i = 0; i < nCoin; i++) {
				int coin = coins[i];
				for(int j = 1; j <= goal; j++) {
					if( j > coin) dp[j] = dp[j] + dp[j-coin];
					else if( j == coin) dp[j]++; 
				}
			}
			System.out.println(dp[goal]);
		}
		
	}
}
