import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n % 3 == 1) {
                sb.append("impossible").append('\n');
                continue;
            }
            int count = 0;
            if (n % 3 == 2) {
                sb.append("BA");
                count += 2;
            }
            while (count < n) {
                sb.append("BBA");
                count += 3;
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}