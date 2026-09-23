import java.io.*;
import java.util.*;
 
public class Solution {
 
    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            
            N = Integer.parseInt(br.readLine().trim());
            arr = new int[N];
            
            int sum = 0;
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            
            Arrays.sort(arr);
            
            int cnt = arr.length;
            
            int idx = arr.length-1;
            
            for (int i = 0; i < cnt/3; i++) {
                
                int min = Math.min(Math.min(arr[idx], arr[idx-1]), arr[idx-2]);
                sum -= min;
                idx -= 3;
                
            }
            sb.append("#"+ tc +" " + sum + "\n");
        }
        System.out.println(sb);
            
    }
 
}