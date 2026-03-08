import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long sum = 0;
		int time = String.valueOf(n).length();
		int length = (int)Math.pow(10, time-1);
		long tmp = 0;
        for(int i = 0; i < time; i++) {
			tmp = n-(length-1);
			sum += tmp * String.valueOf(length).length();
			n -= tmp;
			length /= 10;
		}

        System.out.println(sum%1234567);
	}

}