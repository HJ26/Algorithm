import java.util.*;
import java.io.*;

class Solution {
	static final int SCORE = 0;
	static final int CALORIE = 1;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N + 1][2];
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][SCORE] = Integer.parseInt(st.nextToken());
				arr[i][CALORIE] = Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[N + 1][L + 1];
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < L + 1; j++) {
					if (arr[i][CALORIE] > j) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], arr[i][SCORE] + dp[i - 1][j - arr[i][CALORIE]]);
					}
				}
			}

			sb.append(String.format("#%d %d\n", tc, dp[N][L]));
		}
		System.out.println(sb);
	}
}