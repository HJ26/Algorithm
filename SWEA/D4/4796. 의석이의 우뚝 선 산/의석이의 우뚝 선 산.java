import java.util.*;
 
public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            
            int up = 0;
            int down =0;
            int result = 0;
            for(int i=1; i<N; i++) {
                if(arr[i-1]<arr[i]) {
                    if(down>0) {
                        result += down*up;
                        up=0;
                        down=0;
                    }
                    up++;
                }
                else {
                    down++;
                }
            }
            result += up*down;
            System.out.println("#"+tc+" "+result);
            
        }
    }
}
