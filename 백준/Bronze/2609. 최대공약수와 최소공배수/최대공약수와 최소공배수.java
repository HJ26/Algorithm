import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	
	public static int gcd(int x, int y) {
		int tmp;
		while( y != 0) {
			tmp = x % y;
			x = y;
			y = tmp;
		}
		return x;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		int gcd = gcd(x,y);
		int lcm = gcd;
		
		while(lcm < x || lcm < y ) {
			lcm += gcd;
		}
		
		System.out.println(gcd);
		System.out.println(gcd * ( x / gcd) * ( y / gcd ));
	
	}	
}
