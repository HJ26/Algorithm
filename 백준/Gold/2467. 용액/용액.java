import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] med = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) med[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(med);
        
        int left = 0;
        int right = N-1;
        int minLeft = 0;
        int minRight = 0;
        long min = Long.MAX_VALUE;
        while(left < right) {
            long sum = med[left] + med[right];

            if(Math.abs(sum) > min){
                if(sum > 0) right--;
                else left++;
            }else {
                min = Math.abs(sum);
                minLeft = med[left];
                minRight = med[right];
                
                if(sum < 0) left++;
                else right--;
            }
        }

        System.out.println(minLeft + " " + minRight);
    }
}
