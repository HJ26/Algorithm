import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            
            sb.append('#').append(tc).append(' ');
            String s = br.readLine().trim();
            int n = s.length();
            int ans = 0;
            int i = 0;
            
            int prevLen = 0; 
            char prevC1 = 0; 
            
            while (i < n) {
                if (prevLen != 1 || s.charAt(i) != prevC1) {
                    prevLen = 1;
                    prevC1 = s.charAt(i);
                    ans++;
                    i++;
                } else if (i + 1 < n) {
                    prevLen = 2;
                    ans++;
                    i += 2;
                } else break;
            }
            
            sb.append(ans).append("\n");
        }
        
        System.out.print(sb);
    }
}