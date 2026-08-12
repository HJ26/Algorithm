import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        outer: for (int tc = 1; tc <= T; tc++) {
            
            StringBuilder cards = new StringBuilder(br.readLine());
            int length = cards.length();
            boolean[] visited = new boolean[length];
            for(int i=0; i<length; i++) {
                if(visited[i]) continue;
                if(cards.charAt(i) == '1') {
                    visited[i] = true;
                    if(i == 0) {
                        cards.setCharAt(i+1, cards.charAt(i+1) == '1' ? '0' : '1');
                        i--;
                    } else if(i == length-1) {
                        cards.setCharAt(i-1, cards.charAt(i-1) == '1' ? '0' : '1');
                        i -= 2;
                    } else {
                        cards.setCharAt(i+1, cards.charAt(i+1) == '1' ? '0' : '1');
                        cards.setCharAt(i-1, cards.charAt(i-1) == '1' ? '0' : '1');
                        i -= 2;
                    }
                }
            }
            sb.append("#"+tc+" ");
            for(boolean visit: visited) {
                if(!visit) {
                    sb.append("no"+"\n");
                    continue outer;
                }
            }
            sb.append("yes"+"\n");
        }
        
        br.close();
        System.out.print(sb);
    }
}