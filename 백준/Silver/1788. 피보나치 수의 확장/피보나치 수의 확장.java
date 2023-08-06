import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		if(num > 0) System.out.println(1);
		else if (num == 0) System.out.println(0);
		else {
			if(num%2==0) System.out.println(-1);
			else System.out.println(1);;
		}
		
		num = Math.abs(num);
		long[] rslt = new long[num+1];
		if(num > 0) {
			rslt[1] = 1;
			for(int i = 2; i <= num; i++) {
				rslt[i] = (rslt[i-1]+rslt[i-2])%1000000000; 
			}
		}
		
		System.out.println(rslt[num]);
		
	}
}
