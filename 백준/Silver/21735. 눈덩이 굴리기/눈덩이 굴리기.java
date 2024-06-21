import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        recur(m, 0, 1);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void recur(int time, int cur, int size) {
        if (time == 0 || cur == n) {
            max = Math.max(max, size);
            return;
        }

        if (cur + 1 <= n)
            recur(time - 1, cur + 1, size + arr[cur + 1]);
        if (cur + 2 <= n)
            recur(time - 1, cur + 2, size / 2 + arr[cur + 2]);
    }

}