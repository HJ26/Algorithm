import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nSeat = Integer.parseInt(br.readLine());
		String[] seatInfo = br.readLine().split("");
		double nCup = 1;
		for(int i = 0 ; i < nSeat; i++) {
			switch(seatInfo[i]) {
			case "S":
				nCup++;
				break;
			case "L":
				nCup += 0.5;
				break;
			}
		}
		
		int nPerson = (int)nCup > nSeat ? nSeat : (int)nCup;
		System.out.println(nPerson);
	}
}
