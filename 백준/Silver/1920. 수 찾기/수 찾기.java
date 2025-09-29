import java.io.*;
import java.util.*;

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] targets = new int[M];
        for(int i = 0; i < M; i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums);

        L1:
        for(int target : targets){
        
            int left = 0;
            int right = N-1;
            
            while(left <= right){
                int mid = (left + right) / 2;
                if(nums[mid] == target){
                    System.out.println(1);
                    continue L1;
                }else if(nums[mid] > target){
                    right = mid-1;
                }else left = mid+1;
                
            }
            
            System.out.println(0);
            
        }
    
    }
}