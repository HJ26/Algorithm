import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new HashMap<>();
        int n = read(), max = 0;
        while (n-- > 0) {
            int a = getOddFactor(read());
            map.put(a, map.getOrDefault(a, 0) + 1);
            max = Math.max(max, map.get(a));
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int getOddFactor(int a) {
        while ((a & 1) == 0) a >>= 1;
        return a;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}