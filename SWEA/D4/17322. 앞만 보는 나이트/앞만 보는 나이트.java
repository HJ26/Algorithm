import java.io.*;
import java.util.*;

public class Solution {
    static long MOD = 1_000_000_007;
    static long[] fact = new long[2000001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        initFactorials();

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            if((x + y) % 3 != 0) {
                sb.append("0").append('\n');
                continue;
            }
            
            int a = 2 * y - x;
            int b = 2 * x - y;
            if(a < 0 || b < 0) {
                sb.append("0").append('\n');
                continue;
            }
            a /= 3; b /= 3;
            
            sb.append(nCr(a+b, a)).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void initFactorials() {
        fact[0] = 1;
        for (int i = 1; i <= 2000000; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
    }
    
    static long nCr(int n, int r) {
        long denominator = (fact[r] * fact[n - r]) % MOD;
        return (fact[n] * power(denominator, MOD - 2)) % MOD;
    }
    
    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}