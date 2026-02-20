import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		long sum =0;
		int idx=1;
		while(true) {
			sum = (long)Math.pow(idx, 2)+idx;
			if(sum >2*n) break;
			idx++;
		}
		
		System.out.println(idx-1);
	}
}