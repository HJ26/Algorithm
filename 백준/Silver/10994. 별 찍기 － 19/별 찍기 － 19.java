import java.util.*;
import java.io.*;
 
public class Main {
    static int N;
    static char[][] star;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        N = Integer.parseInt(br.readLine());
        N = 4 * N - 3;
 
        star = new char[N][N];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                star[i][j] = ' ';
            }
        }
 
        makeStar(0, N);
 
        StringBuilder sb = new StringBuilder();
        for(char[] ch : star) {
            for(char c : ch) {
                sb.append(c);
            }
            sb.append("\n");
        }
 
        System.out.println(sb);
    }
 
    private static void makeStar(int s, int len) {
        if(len <= s)    return;
 
        for(int i = s ; i < len ; i++) {
            star[s][i] = '*';       
            star[len - 1][i] = '*'; 
            star[i][s] = '*';      
            star[i][len - 1] = '*';
        }
 
        makeStar(s + 2, len - 2);
    }
}