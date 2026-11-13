import java.util.Scanner;

public class Solution {
	public static int pow(int x, int y) {
		if(y == 0)
			return 1;
		return x * pow(x, y-1);
	}
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int test = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println("#" + tc + " " + pow(x, y));
		}
	}
}