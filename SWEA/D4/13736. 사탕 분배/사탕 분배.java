import java.io.*;
import java.util.*;

public class Solution {
	
	static long mod;
 
	public static void main(String[] args) throws Exception{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			long K = Long.parseLong(st.nextToken());
			
			mod = A + B;
			long kp = power(K);
            
			A = (A * kp) % mod;
			long result = Math.min(A, mod - A);
			sb.append("#"+tc+" "+result+"\n");
		}
		System.out.println(sb);
	}
 
	private static long power(long n) {
		if(n == 1) return 2;
		
		long ret = power(n / 2);
		ret = (ret * ret) % mod;
		if((n & 1) == 1) ret = (ret * 2) % mod;
		
		return ret;
	}
}