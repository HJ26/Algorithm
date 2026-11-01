import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while (T-- > 0) {
			int B = sc.nextInt();
			int W = sc.nextInt();
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int Z = sc.nextInt();
			
			int diff_score = 0;
			
			if (B == W) {
				diff_score = (B+W) * Z;
			} else if (B > W) {
				int max_diff_cnt = W * 2;
				
				diff_score = max_diff_cnt * Z + (B - max_diff_cnt / 2) * X;
			} else {
				int max_diff_cnt = B * 2;
				
				diff_score = max_diff_cnt * Z + (W - max_diff_cnt / 2) * Y;
			}
			
			int same_score = B * X + W * Y;
			
			int answer = Math.max(diff_score, same_score);
			
			System.out.println(answer);
		}
	}
}