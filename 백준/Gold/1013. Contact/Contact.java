import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String pattern = "(100+1+|01)+";
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < T; tc++) {
            String target = br.readLine();
            if(target.matches(pattern)) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}    
