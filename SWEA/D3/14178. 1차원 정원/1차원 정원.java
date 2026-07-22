import  java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
       
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			
            st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            
            int answer = (int) Math.ceil(N/(double)(2*D+1));
            
            sb.append("#"+tc+" "+answer+"\n");
		}
        System.out.println(sb);
	}
}