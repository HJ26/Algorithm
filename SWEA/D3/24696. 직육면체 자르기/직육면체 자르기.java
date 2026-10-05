import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            if(a % 2 != 0 && b % 2 != 0 && c % 2 != 0) {
                sb.append('2');
            } else {
                sb.append('1');
            }
            sb.append('\n');
        }
        br.close();
        System.out.print(sb);
    }
}