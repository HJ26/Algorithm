import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int Q = sc.nextInt();
            
            int[] arr = new int[N+1];
            for(int i = 1; i <= Q; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                for(;a <= b; a++){ arr[a] = i;}
            }
            
            sb.append("#" + tc + " ");
            for(int i = 1; i <=N ;i++){
                sb.append(arr[i] + " ");
            }
           sb.append("\n");
		}
        System.out.println(sb);
	}
}