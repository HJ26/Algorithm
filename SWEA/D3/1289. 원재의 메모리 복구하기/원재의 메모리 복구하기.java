import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int cnt = 0;
            String data = sc.next();
            int prev = 0;
            for (int i = 0; i < data.length(); i++) {
                int cur = data.charAt(i) - '0';

                if (prev != cur) {
                    prev = cur;
                    cnt++;
                }
            }

            System.out.println("#" + tc + " " + cnt);
        }
    }
}