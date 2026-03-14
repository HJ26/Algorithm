import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int num = A * D + B * C;
        int den = B * D;
        
        int mod = gcd(num, den);
        num /= mod;
        den /= mod;

        sb.append(num + " " + den + "\n");
        System.out.println(sb.toString());
    }

    public static int gcd(int a, int b) {
        
        if (a <= b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (b == 0) {
            return a;
        }
        return gcd(b , a % b);
    }

}