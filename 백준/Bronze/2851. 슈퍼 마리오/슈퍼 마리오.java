import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int mush = 0, sum = 0;
		int[] rooms = new int[10];
		for(int i = 0; i < 10; i++) {
			rooms[i] = Integer.parseInt(br.readLine());
		}
		
		for(int m : rooms ) {
			mush = m;
			sum += mush;
			if( sum >= 100 ) break;
		}
		
		if ( sum - 100 > 100 - ( sum - mush )) {
			sum -= mush;
		}
		
		bw.write(String.valueOf(sum));
		bw.close();
	}
}
