 import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            
            sb.append('#').append(tc).append(' ');
            String results = br.readLine();
            int length = results.length();
            int win = 0;
            for(int i=0; i<length; i++) {
                if(results.charAt(i) == 'o') win++;
            }
            
            if(15 - length >= 8 - win) sb.append("YES").append('\n');
            else sb.append("NO").append('\n'); 
        }
        
        System.out.print(sb);
    }
}