import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
	// 소수 판별
	public static boolean isPrime(int n) {
		for( int i = 2; i <= Math.sqrt(n); i++) {
			if( n % i == 0)
				return false;
		}
		return true;
	}
	
	// 팰린드롬 판별
	public static boolean isPalindrome(int n) {
		
		String[] pal = Integer.toString(n).split("");
		int palLen = pal.length;
		
		boolean isPalin = true;
		for( int i = 0; i < palLen/2; i++) {
			if ( !pal[i].equals(pal[palLen-i-1])){
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if (n == 1) {
			System.out.println(2);
		}else {
			for(int i = n; ; i++) {
				if (isPalindrome(i)) {
					if(isPrime(i)) {
						System.out.println(i);
						break;
					}
				}
			}
		}
	}
}
