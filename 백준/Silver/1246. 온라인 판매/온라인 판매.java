import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Integer P[] = new Integer[M];
        for(int i =0;i<M;i++){
            P[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(P, Collections.reverseOrder());


        int price = 0;
        int maxPrice = 0;
        int range = Math.min(M,N);
        for(int i=0;i<range;i++){

            int tempPrice = (i+1) * P[i];

            if(maxPrice < tempPrice){
                maxPrice = tempPrice;
                price = P[i];
            }
        }
        System.out.println(price+" "+maxPrice);
    }
}