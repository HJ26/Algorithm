import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
            
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append("#"+tc+" ");
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            int start = Math.max(a, c), end = Math.min(b, d);
            if(start > end) sb.append(0);
            else sb.append(end - start);
            sb.append("\n");
        }
        
        System.out.print(sb);
    }

}