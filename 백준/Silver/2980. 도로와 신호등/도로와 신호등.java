import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
 
        int position = 0;
        int time = 0;
 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
 
            time += D - position;
            position = D;
 
            int gap = time%  (R + G);
            if (gap < R) time += R - gap;           
        }
 
        time += L-position;
 
        System.out.println(time);
    }
}