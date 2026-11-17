import java.util.Scanner;

public class Solution {
    
    public static int[] arr;
    public static int N,K, count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            count = 0;
            N = sc.nextInt();
            arr = new int[N];
            K = sc.nextInt();
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            dfs(0, 0);
            System.out.println("#" + tc + " " + count);
        }
    }

    public static void dfs(int start, int sum) {
        if (sum > K) {
            return;
        }
        if (start == arr.length) {
            if (sum == K) {
                count++;
            }
            return;
        }
        dfs(start + 1, sum + arr[start]);
        dfs(start + 1, sum);
    }
}