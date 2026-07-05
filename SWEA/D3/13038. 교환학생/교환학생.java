import java.util.*;
import java.io.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {  
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int [7];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0; i<7; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
             
            int min = Integer.MAX_VALUE;
             
            for(int i =0; i<7; i++){
                if(arr[i]==0){
                    continue;
                }
                int start = i;
                int day = 0;
                int count = 0;
                   
                while(count <N){
                    if(arr[start%7] == 1){
                        count++;
                    }
                    day++;
                    start++;
                }
                min= Math.min(min, day);
            }
             
            System.out.println("#"+t+" "+min);
        }
    }
}