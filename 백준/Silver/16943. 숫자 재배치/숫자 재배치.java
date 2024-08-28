import java.io.*;
import java.util.*;

public class Main {
    
    static String A, B, C;
    static int a,b,c;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        A = stringTokenizer.nextToken();
        B = stringTokenizer.nextToken();
        C = "";

        a = Integer.parseInt(A);
        b = Integer.parseInt(B);
        c = -1;

        visit = new boolean[A.length()];

        dfs();

        System.out.println(c);
    }
    
    private static void dfs() {

        if(C.length() == A.length()){
            if(Integer.parseInt(C) < b)
                c = Math.max(c, Integer.parseInt(C));
            return;
        }

        for(int i = 0 ; i < A.length(); i++){
            if((C.length() == 0 && A.charAt(i) == '0') || visit[i])   continue;

            visit[i] = true;
            C += A.charAt(i);
            dfs();
            visit[i] = false;
            C = C.substring(0, C.length()-1);
        }
    }
}