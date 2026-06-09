import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(tc-- > 0) {
            StringBuilder s = new StringBuilder(br.readLine());
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                int a = Integer.parseInt(st.nextToken());
                if(a > 0) {
                    a %= s.length();
                    for(int j=0; j<a; j++) {
                        s.append(s.charAt(0));
                        s.deleteCharAt(0);
                    }
                } else {
                    a = Math.abs(a);
                    a %= s.length();
                    for(int j=0; j<a; j++) {
                        s.insert(0, s.charAt(s.length()-1));
                        s.deleteCharAt(s.length()-1);
                    }
                }
            }
            sb.append(s.toString()).append('\n');
        }
        System.out.print(sb);
    }
}