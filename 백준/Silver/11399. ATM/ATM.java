import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nPerson = Integer.parseInt(br.readLine());
		String[] timeTmp = br.readLine().split(" ");
		int[] time = new int[nPerson];
		for(int i =0 ; i < nPerson; i++) {
			time[i] = Integer.parseInt(timeTmp[i]);
		}
		for(int i = 0; i < nPerson; i++) {
			for(int j = i+1; j < nPerson; j++) {
				if(time[i] > time[j]) {
					int tmp = time[j];
					time[j] = time[i];
					time[i] = tmp;
				}
			}
		}
		
		int totalSum = time[0];
		for(int i = 1; i < nPerson; i++) {
			time[i] = time[i-1]+time[i];
			totalSum += time[i];
		}
		System.out.println(totalSum);
		
	}
}
