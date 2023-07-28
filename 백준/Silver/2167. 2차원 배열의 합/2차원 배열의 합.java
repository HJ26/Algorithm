import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		for(int k = 0; k < n; k++) {
			for(int l = 0; l < m; l++) {
				arr[k][l] = sc.nextInt();
			}
		}
		
		int nSum = sc.nextInt();
		int[] sum = new int[nSum];
		int i;
		int j;
		int x;
		int y;
		for(int k = 0; k < nSum; k++) {
			i = sc.nextInt();
			j = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			for(int l = i-1; l < x; l++) {
				for(int o = j-1; o<y; o++) {
					sum[k] += arr[l][o];
				}
			}
			
		}
		for(int k = 0; k<nSum; k++) {
			System.out.println(sum[k]);
		}
	}
}
