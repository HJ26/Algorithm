import java.io.*;
import java.util.*;

public class Solution {

	static long ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
			ans = 0;
			long pos = 1;
			while(A<=B) {
				while(A%10 != 0 && A<=B) {
					calc(A,pos);
					A++;
				}
				if(A>B || (A==0 && B== 0)) break;
				while(B%10 != 9 && A<=B) {
					calc(B,pos);
					B--;
				}
				A/=10;
				B/=10;
				long m = (B - A + 1) * pos;
				ans+= m*45;
				pos *= 10;
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
        System.out.println(sb);
	}
    
	static void calc(long n, long t) {
		while(n>0) {
			ans+= (n % 10)*t;
			n/= 10;
		}
	}
}