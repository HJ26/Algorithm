import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nSquare = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int n = 1; n <= nSquare; n++) {
			for(int i = 1; i <= n; i++) {
				if(n % i == 0) {
					if(i > n/i) break;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
