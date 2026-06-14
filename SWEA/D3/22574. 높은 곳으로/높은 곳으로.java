import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());
            if ((n * (n + 1)) / 2 < p) {
                sb.append((n * (n + 1)) / 2).append('\n');
                continue;
            }
            int sum = (n * (n + 1)) / 2;
            int current = 0;
            for (int i = 1; i <= n; i++) {
                current += i;
                if (current == p) {
                    sum--;
                    break;
                }
                if (current > p) {
                    break;
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}