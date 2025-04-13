import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int noContain = (int) Math.round(N*0.15);

        for (int i = 0; i < noContain; i++) {
            nums[i] = 0;
            nums[N-1-i] = 0;
        }

        int sum = Arrays.stream(nums).sum();
        N = N - (noContain*2);

        System.out.println((int) Math.round((double) sum / N));

    }
}