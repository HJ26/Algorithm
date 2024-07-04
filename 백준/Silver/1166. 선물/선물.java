import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());
        double min = L;
        min = Math.min(min, W);
        min = Math.min(min, H);

        double l = 0;
        double h = min;
        double mid;

        for(int i=0; i<5000; ++i){
            mid = (l+h) / 2;

            if((long)(L/mid) * (long)(W/mid) * (long)(H/mid) < N){
                h = mid;
            }
            else{
                l = mid;
            }
        }

        bw.write(Double.toString(l));
        bw.close();
        br.close();
    }
}

