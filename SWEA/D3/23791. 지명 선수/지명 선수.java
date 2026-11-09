import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		while (T-- > 0) {
			int N = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[N];
			
			for (int a = 0; a < N; a++) A[a] = sc.nextInt();
			
			
			for (int b = 0; b < N; b++) B[b] = sc.nextInt();
			
			char[] answer = new char[N];
			
			int a_idx = 0;
			int b_idx = 0;
			
			for (int i = 0; i < N; i++) {
				while (true) {
					if (a_idx >= N) break;
					
					int A_num = A[a_idx];
					
					if (answer[A_num - 1] == 0) {
						answer[A_num - 1] = 'A';
						break;
					}
					
					a_idx++;
				}
				
				while (true) {
					if (b_idx >= N) {
						break;
					}
					
					int B_num = B[b_idx];
					
					if (answer[B_num - 1] == 0) {
						answer[B_num - 1] = 'B';
						break;
					}
					
					b_idx++;
				}
			}
			
			for (int i = 0; i < N; i++) sb.append(answer[i]);
			sb.append("\n");
		}
        System.out.println(sb);
	}
}