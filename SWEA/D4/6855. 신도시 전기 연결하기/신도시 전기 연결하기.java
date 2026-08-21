import java.io.*;
import java.util.*;

public class Solution {
	public static int N, K, answer;
	public static int[] cityMap, cityLen;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st = null;		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			cityMap = new int[N];
			
			cityLen = new int[N - 1];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; ++i) {
				cityMap[i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			
			for (int i = 0; i < N - 1; ++i) {
				cityLen[i] = cityMap[i + 1] - cityMap[i];
			}
			
			Arrays.sort(cityLen);
			
			for (int i = 0; i < N - K; ++i) {
				answer += cityLen[i];
			}
			
			sb.append("#"+tc+" "+answer+"\n");
		}
		
		System.out.println(sb);
	}
}