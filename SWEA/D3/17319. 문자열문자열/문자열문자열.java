import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        outer: for (int tc = 1; tc <= T; tc++) {
            sb.append("#"+tc+" ");
            int length = Integer.parseInt(br.readLine());
            String str = br.readLine();
            if(length % 2 == 1) {
                sb.append("No"+'\n');
                continue;
            }
            
            for(int i=0; i<length/2; i++) {
                if(str.charAt(i) != str.charAt(length/2 + i)) {
                    sb.append("No"+'\n');
                    continue outer;
                }
            }
            sb.append("Yes"+'\n');
        }
        System.out.println(sb);
    }
}