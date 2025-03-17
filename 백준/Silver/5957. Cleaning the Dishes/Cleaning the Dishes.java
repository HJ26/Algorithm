import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> unwashed = new Stack<>();
        Stack<Integer> washed = new Stack<>();
        Stack<Integer> dried = new Stack<>();

        for (int i = n; i >= 1; i--)
            unwashed.push(i);

        while (dried.size() != n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            int d = Integer.parseInt(st.nextToken());

            if (c.equals("1")) while (d-- > 0) washed.push(unwashed.pop());
            else while (d-- > 0) dried.push(washed.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!dried.empty()) sb.append(dried.pop()).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}