import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            if(c < 3 || b < 2) {
                sb.append("-1").append('\n');
                continue;
            }
            int count = 0;
            if(b >= c) {
                count += b - c + 1;
            }
            b = c - 1;
            if(a >= b) {
                count += a - b + 1;
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
}