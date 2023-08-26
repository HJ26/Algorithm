import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarf = new int[9];
		
		for(int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		int rslt[] = new int[7];
		int rmIdx1 = 0;
		int rmIdx2 = 1;
		while(rmIdx1 < 8) {
			int cnt = 0;
			for(int i = 0, idx = 0; i < 9; i++) {
				if( i != rmIdx1 && i != rmIdx2) {
					cnt += dwarf[i];
					rslt[idx++] = dwarf[i];
				}
			}
			if(cnt == 100) break;
			if(++rmIdx2 == 9) {
				rmIdx1++;
				rmIdx2 = rmIdx1+1;
			}
		}
		
		for(int i =0; i < 7; i++) {
			for(int j = i+1; j < 7; j++) {
				if(rslt[i]>rslt[j]) {
					int tmp = rslt[i];
					rslt[i] = rslt[j];
					rslt[j] = tmp;
				}
			}
			System.out.println(rslt[i]);
		}
	}
}
