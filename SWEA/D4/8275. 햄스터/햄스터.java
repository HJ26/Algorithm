import java.io.*;
import java.util.*;

public class Solution {
    static int N, X, M;
    static int[] arr, answer;
    static int[][] memo;
    static int max_sum;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
 
            arr = new int[N];
            memo = new int[M][3];
            answer = new int[N];
 
            max_sum = -1;
 
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                memo[i][0] = Integer.parseInt(st.nextToken())-1;
                memo[i][1] = Integer.parseInt(st.nextToken())-1;
                memo[i][2] = Integer.parseInt(st.nextToken());
            }
 
            dfs(0);
 
            System.out.print("#" + t + " ");
            if(max_sum == -1) {
                System.out.println(-1);
            } else {
                for(int i=0; i<N; i++) {
                    System.out.print(answer[i] + " ");
                }
                System.out.println();
            }
 
        }
 
    }
 
    public static void dfs(int cnt) {
        if(cnt==N) {
            for(int i=0; i<M; i++) {
                int check_sum = 0;
                for(int j=memo[i][0]; j<=memo[i][1]; j++) {
                    check_sum += arr[j];
                }
                if (check_sum != memo[i][2]) return;
            }
 
            int sum = 0;
            for(int i=0; i<N; i++) {
                sum += arr[i];
            }
            if(sum > max_sum) {
                max_sum = sum;
                answer = Arrays.copyOf(arr, N);
            }
            return;
        }
 
        for(int i=0; i<=X; i++) {
            arr[cnt] = i;
            dfs(cnt+1);
        }
    }
}