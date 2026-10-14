import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(str.nextToken());

        for(int tc=1; tc<=T; tc++) {
            String answer = "no";
            str = new StringTokenizer(br.readLine());
            String a = str.nextToken();
            String b = str.nextToken();

            BigInteger alength = BigInteger.valueOf(a.length());
            BigInteger blength = BigInteger.valueOf(b.length());
            int gcd = alength.gcd(blength).intValue();
            int lcm = (a.length() * b.length()) / gcd;

            String A = a;
            String B = b;
            while(A.length()!=lcm)  A+=a;

            while(B.length()!=lcm) B+=b;

            if(A.equals(B)) answer="yes";

            sb.append("#"+tc+" "+answer+"\n");
        }

        System.out.print(sb);

    }
}