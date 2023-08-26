import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] tmpInput = br.readLine().split(" ");
		
		int nPerson = Integer.parseInt(tmpInput[0]);
		int maxCnt = Integer.parseInt(tmpInput[1]);
		int dIdx = Integer.parseInt(tmpInput[2]);
		int totalMove = 0;
		int idx = 1;
		int[] cnt = new int[nPerson];
		cnt[idx] = 1;
		while(cnt[idx] < maxCnt) {
			if(cnt[idx] % 2 == 0) {
				idx = Math.abs(idx+nPerson-dIdx) % nPerson;
			}else {
				idx = (idx+dIdx) % nPerson;
			}
			cnt[idx]++;
			totalMove++;
		}
		
		System.out.println(totalMove);
	}
}
