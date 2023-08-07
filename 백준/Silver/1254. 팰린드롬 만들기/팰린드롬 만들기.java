import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	// 팰린드롬 판별
	public static boolean isPalindrome(String str) {
		
		String[] pal = str.split("");
		int palLen = pal.length;
		
		for( int i = 0; i < palLen/2; i++) {
			if ( !pal[i].equals(pal[palLen-i-1])){
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("");
		int palinLen = str.length-1;
		
		for(int i = str.length-1; i >= 0; i--) {
			String target = "";
			for(int j = str.length-1; j >= i; j--) {
				target += str[j];
			}
			if( isPalindrome(target)==true ) {
				palinLen = i;
			}
		}
		
		System.out.println(str.length + palinLen);
		
	}
}
