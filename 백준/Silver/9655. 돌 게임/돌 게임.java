import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nStone = Integer.parseInt(br.readLine());
		
		if(nStone % 2 == 1) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
	}
}
