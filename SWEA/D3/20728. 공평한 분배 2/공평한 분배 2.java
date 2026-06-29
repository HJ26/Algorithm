import java.io.*;
import java.util.*;
 
class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for(int i = 1; i<=T; i++) {
             
            st= new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int [] arr=  new int[N];
            List<Integer> list = new ArrayList<Integer>();
             
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++) {
                arr[j]=Integer.parseInt(st.nextToken());
            }
             
            Arrays.sort(arr);
             
            int min = Integer.MAX_VALUE;
            for(int j=0; j<N-K+1; j++) {
                min=Math.min(min, arr[j+K-1]-arr[j]);
            }
            sb.append("#").append(i+" ").append(min).append("\n");  
        }
        System.out.println(sb);
 
    }
 
}