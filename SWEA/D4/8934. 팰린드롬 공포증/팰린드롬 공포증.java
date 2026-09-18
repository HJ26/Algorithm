import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.nextLine();
			int[] numbers = new int[3];
			int len = str.length();
			for (int i = 0; i < len; i++) {
				char c = str.charAt(i);
				if (c == 'a')
					numbers[0]++;
				if (c == 'b')
					numbers[1]++;
				if (c == 'c')
					numbers[2]++;
			}
			int max = Arrays.stream(numbers).max().getAsInt();
			int min = Arrays.stream(numbers).min().getAsInt();
			if (max - min <= 1)
				bw.write("#" + test_case + " YES\n");
			else
				bw.write("#" + test_case + " NO\n");
		}
		
		bw.flush();
		bw.close();
	}
}