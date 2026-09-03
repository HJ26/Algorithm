import java.io.*;
import java.util.*;

public class Solution {
	public static int[] keypad = new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;
		
		initKeypad();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int answer = 0;
			for (int i = 0; i < N; ++i) {
				String word = st.nextToken();
				
				answer++;
				for (int j = 0; j < word.length(); ++j) {
					if (S.charAt(j) - '0' != keypad[word.charAt(j) - 'a']) {
						answer--;
						break;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void initKeypad() {
		int num = 1;
		int cnt = 0;

		for (int i = 'a'; i <= 'z'; ++i) {
			if (cnt % 3 == 0) {
				num++;
			}
			
			cnt++;
			
			if (i == 's' || i == 'z') {
				num--;
				cnt = 0;
			}
			
			keypad[i - 'a'] = num;
		}
	}
}