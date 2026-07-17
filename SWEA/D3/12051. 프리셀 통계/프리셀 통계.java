import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
		
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            int pd = Integer.parseInt(st.nextToken());
            int pg = Integer.parseInt(st.nextToken());
            String rslt = "Broken";
            if(!((pd != 0 && pg == 0) || (pd != 100 && pg == 100))){
                while(N > 0){
                    if( (N * pd) % 100 == 0){
                        rslt = "Possible";
                        break;
                    }
                    N--;
                }
            }
            sb.append("#" + tc + " " + rslt + "\n");
		}
        System.out.println(sb);
	}
}