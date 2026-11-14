import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<= T; tc++) {
            sb.append("#"+tc+" ");
            String s = br.readLine();
            String e = br.readLine();
            StringBuilder word = new StringBuilder(e);
            
            while(word.length() > s.length()) {
                if(word.charAt(word.length()-1) == 'X') {
                    word.deleteCharAt(word.length()-1);
                } else {
                    word.deleteCharAt(word.length()-1);
                    word = word.reverse();
                }
            }
            
            if(s.equals(word.toString())) {
                sb.append("Yes");
            } else {
                sb.append("No");
            }
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}