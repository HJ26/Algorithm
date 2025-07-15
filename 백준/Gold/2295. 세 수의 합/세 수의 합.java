import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        int kIdx = N-1;
        while(kIdx > 0) {
            for(int xIdx = 0; xIdx <= kIdx; xIdx++) {
                int yIdx = xIdx;
                int zIdx = N-1;

                while(yIdx <= zIdx){
                    int sum = nums[xIdx] + nums[yIdx] + nums[zIdx];
                    if(sum == nums[kIdx]){
                        System.out.println(nums[kIdx]);
                        return;
                    }
                    else if(sum > nums[kIdx]) zIdx--;
                    else yIdx++;
                }
            }
            kIdx--;
        }
    }
}
