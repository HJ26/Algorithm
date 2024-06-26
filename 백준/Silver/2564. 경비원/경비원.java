import java.io.*;
import java.util.*;

public class Main {
    private static int w, h;
    private static List<Integer> shops = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int total = (w + h) * 2;

        int shopCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < shopCount + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (dir == 1) {
                shops.add(pos);
            } else if (dir == 2) {
                shops.add(w + h + (w - pos));
            } else if (dir == 3) {
                shops.add(2 * w + h + (h - pos));
            } else if (dir == 4) {
                shops.add(w + pos);
            }
        }

        int myPos = shops.get(shops.size() - 1);
        int answer = 0;
        for (int value : shops) {
            int temp = Math.abs(myPos - value);
            answer += Math.min(temp, total - temp);
        }

        System.out.println(answer);
    }
}