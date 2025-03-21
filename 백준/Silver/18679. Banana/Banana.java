import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, String> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] arr = br.readLine().split(" = ");
            map.put(arr[0], arr[1]);
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (k-- > 0) sb.append(map.get(st.nextToken())).append(" ");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}