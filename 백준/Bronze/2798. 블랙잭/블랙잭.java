import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int nCard = Integer.parseInt(input[0]);
		int target = Integer.parseInt(input[1]);
		
		int[] cards = new int[nCard];
		input = new String[nCard];
		input = br.readLine().split(" ");
		for(int i =0 ; i < nCard; i++) {
			cards[i] = Integer.parseInt(input[i]);
		}
		
		int max = 0;
		for(int i = 0; i < nCard-2; i++) {
			for(int j = i+1; j < nCard-1; j++) {
				for(int k = j+1; k < nCard; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if( sum <= target && sum > max) max = sum;
				}
			}
		}
		
		System.out.println(max);
		
	}
}
