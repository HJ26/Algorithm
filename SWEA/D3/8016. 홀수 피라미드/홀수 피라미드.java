import java.io.*;
import java.util.*;
 
public class Solution {
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        long N = 0;
        long result1 = 0;
        long result2 = 0;
        for(int tc=1; tc<=T; tc++) {
            N = Long.parseLong(br.readLine());
            result1 = 2*(N-1)*(N-1) + 1;
            result2 = 2*N*N - 1;
            sb.append("#"+tc+" "+result1+" "+result2+"\n");
        }
        System.out.println(sb);
    }
 
}