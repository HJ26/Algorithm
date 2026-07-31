import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#"+tc+" ");
            String P = br.readLine(), Q = br.readLine();
            
            
            if((P + 'a').equals(Q)) sb.append("N"+"\n");
            else sb.append("Y"+"\n");
        }
        
        System.out.print(sb);
    }
}