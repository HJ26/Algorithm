import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(arr);
            int answer = arr[0] * arr[N-1];
            sb.append("#" + tc + " " + answer+"\n");
        }
        System.out.println(sb);
    }
}