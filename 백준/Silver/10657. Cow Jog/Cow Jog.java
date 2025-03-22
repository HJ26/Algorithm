import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<>();

        while (n-- > 0) {
            int speed = Integer.parseInt(br.readLine().split(" ")[1]);

            while (!stk.empty() && stk.peek() > speed) stk.pop();

            stk.push(speed);
        }

        bw.write(String.valueOf(stk.size()));
        bw.close();
    }

}