import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int divNum = 1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] scov = new int[N];
		for(int i = 0; i < N; i++) {
			scov[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(scov);
		long totalScov = 0;
		for(int i = 0; i < N; i++) {
			totalScov += scov[i]*pow(2,i);		// 최대값이 i 인 경우
			totalScov -= scov[i]*pow(2,N-1-i);	// 최소값이 i 인 경우
			totalScov %= divNum;
		}
		System.out.println(totalScov);
	}
	
	public static long pow(int base, int num) {
		if( num == 0) return 1L;
		long half = pow(base, num/2);
		if( num % 2 == 0) return half * half % divNum;
		return half * half * base % divNum;
	}
}
