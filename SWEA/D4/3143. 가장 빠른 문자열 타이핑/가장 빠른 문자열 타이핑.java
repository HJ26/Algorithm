import java.io.*;
import java.util.*;


public class Solution {
	public static String A, B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			
			A = st.nextToken();
			B = st.nextToken();
			
			String answer = A.replaceAll(B, "c");
			
			sb.append("#"+tc+" "+answer.length()+"\n");
		}
		
		System.out.println(sb);
	}
}