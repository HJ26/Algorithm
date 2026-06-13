import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        outer: while(T-- > 0) {
            String str = br.readLine();
            if(str.length() % 2 != 0) {
                sb.append("no").append('\n');
                continue;
            }
            int[] board = new int[10];
            for(int i=0; i<str.length(); i++) {
                int number = Integer.parseInt(str.substring(i, i+1));
                if(board[number] == 1) {
                    board[number] = 2;
                    continue;
                }
                if(board[number] >= 2) {
                    sb.append("no").append('\n');
                    continue outer;
                }
                if(i + number + 1 >= str.length()) {
                    sb.append("no").append('\n');
                    continue outer;
                }
                if(Integer.parseInt(str.substring(i + number + 1, i + number + 2)) == number) {
                    board[number] = 1;
                } else {
                    sb.append("no").append('\n');
                    continue outer;
                }
            }
            sb.append("yes").append('\n');
        }
        System.out.print(sb);
    }
}