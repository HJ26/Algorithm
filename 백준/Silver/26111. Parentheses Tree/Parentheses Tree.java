import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> stk = new Stack<>();

        long sum = 0;
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stk.push(s.charAt(prev = i));
            else {
                stk.pop();
                if (i == prev + 1) sum += stk.size();
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}