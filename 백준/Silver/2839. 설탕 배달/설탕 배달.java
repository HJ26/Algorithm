import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int weight = Integer.parseInt(br.readLine());
		int nSugar = 0;
		while( true ) {
			int tmpWeight = weight % 5;
			if (tmpWeight % 3 == 0) {
				nSugar += weight/5;
				nSugar += tmpWeight/3;
				break;
			}else {
				nSugar++;
				weight -= 3;
			}
			if(weight <= 0) {
				nSugar = -1;
				break;
			}
			
		}
		
		System.out.println(nSugar);
	}
}
