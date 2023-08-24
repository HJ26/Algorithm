import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		int cnt = 1;
		int sum = 1;
		if(N != 1) {
			while( N > sum ) {
				sum += cnt*6;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
