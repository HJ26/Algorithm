import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');
            StringTokenizer st = new StringTokenizer(br.readLine());
            String set = st.nextToken();
            int length = set.length();
            long n = Long.parseLong(st.nextToken());
            StringBuilder result = new StringBuilder();
            while (n > 0) {
                n--;
                int remainder = (int) (n % length);
                result.append(set.charAt(remainder));
                n /= length;
            }
            sb.append(result.reverse().toString()+'\n');
        }
        System.out.print(sb);
    }
}