import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nRound = Integer.parseInt(br.readLine());
		String rslt;
		for(int rod = 0; rod < nRound; rod++) {
			rslt = "D";
			String[] aTmp = br.readLine().split(" ");
			String[] bTmp = br.readLine().split(" ");
			int[] aInfo = new int[5];
			int[] bInfo = new int[5]; 
			for( int i = 1 ; i <= Integer.parseInt(aTmp[0]); i++) {
				aInfo[Integer.parseInt(aTmp[i])]++;
			}
			
			for( int i = 1 ; i <= Integer.parseInt(bTmp[0]); i++) {
				bInfo[Integer.parseInt(bTmp[i])]++;
			}
			
			for(int i = 4; i > 0; i--) {
				if(aInfo[i] > bInfo[i]) {
					rslt = "A";
					break;
				}
				else if(aInfo[i] < bInfo[i]) {
					rslt = "B";
					break;
				}
			}
			System.out.println(rslt);
		}
	}
}
