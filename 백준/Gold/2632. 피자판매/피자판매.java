import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int rslt = 0;

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] pa = new int[M];
        int[] pb = new int[N];
        int sumA = 0;
        int sumB = 0;

        for(int i = 0; i < M; i++) {
            pa[i] = Integer.parseInt(br.readLine());
            sumA += pa[i];
        }
        for(int i = 0; i < N; i++) {
            pb[i] = Integer.parseInt(br.readLine());
            sumB += pb[i];
        }

        int[] dpA = new int[T+1];
        int[] dpB = new int[T+1];
        dpA[0] = 1;
        dpB[0] = 1;

        int tmp = 0;
        for(int i = 0; i < M; i++){
            tmp = 0;
            for(int j = 0; j < M-1; j++){
                if(pa[(i+j)%M] + tmp > T) break;
                tmp += pa[(i+j)%M];
                dpA[tmp]++;
            }
        }

        for(int i = 0; i < N; i++){
            tmp = 0;
            for(int j = 0; j < N-1; j++){
                if(pb[(i+j)%N] + tmp > T) break;
                tmp += pb[(i+j)%N];
                dpB[tmp]++;
            }
        }

        if(sumA > T) dpA[0] = 1;
        else dpA[sumA] = 1;

        if(sumB > T) dpB[0] = 1;
        else dpB[sumB] = 1;

        for(int i = 0; i <= T; i++) rslt += dpA[i] * dpB[T-i];

        System.out.println(rslt);
    }
}
