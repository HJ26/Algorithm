import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');
            String number = br.readLine();
            int min = Integer.MAX_VALUE;
            for(int i=1; i<number.length(); i++) {
               int sum = Integer.parseInt(number.substring(0, i)) + Integer.parseInt(number.substring(i));
               min = Math.min(sum, min);
            }
            sb.append(min).append('\n');
        }
        
        System.out.print(sb);
    }
}