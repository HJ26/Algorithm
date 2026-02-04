import java.io.*;
import java.util.*;

public class Main {

    static long N, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        R = Long.parseLong(st.nextToken());

        System.out.println(N + 1 + 2 * (R - 1));
    }
}