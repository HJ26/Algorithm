import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");
        int E = Integer.parseInt(split[0]);
        int S = Integer.parseInt(split[1]);
        int M = Integer.parseInt(split[2]);

        int e = 0, s = 0, m = 0;
        int answer = 0;

        while (true) {
            e++;
            s++;
            m++;
            answer++;
            if (e > 15) e = 1;
            if (s > 28) s = 1;
            if (m > 19) m = 1;

            if (e == E && s == S && m == M) break;
        }

        bw.write(answer + "\n");

        bw.flush();
    }
}