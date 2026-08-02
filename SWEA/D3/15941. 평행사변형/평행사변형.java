import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            sb.append("#"+tc+" "+N*N+"\n");
        }
        System.out.println(sb);
    }
}