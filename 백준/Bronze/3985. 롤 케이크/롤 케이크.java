import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int lenCake = Integer.parseInt(br.readLine());
		int nPerson = Integer.parseInt(br.readLine());
		
		int[] cake = new int[lenCake+1];
		int thinkMax = 0;
		int thinkMaxPerson = 0;

		int[] cnt = new int[nPerson+1];
		for(int personNo =1 ; personNo <= nPerson; personNo++) {
			String[] input = br.readLine().split(" ");
			int startNo = Integer.parseInt(input[0]);
			int endNo = Integer.parseInt(input[1]);
			int nCake = endNo-startNo;
			if(nCake > thinkMax) {
				thinkMax = nCake;
				thinkMaxPerson = personNo;
			}
			
			for(int i = startNo; i <= endNo; i++) {
				if(cake[i] == 0) {
					cake[i] = personNo;
					cnt[personNo]++;
				}
			}
		}
		
		int realMax= 0;
		int realMaxPerson = 0;
		for(int i = 1; i < nPerson+1; i++) {
			if(realMax < cnt[i]) {
				realMax = cnt[i];
				realMaxPerson = i;
			}
		}
		
		System.out.println(thinkMaxPerson);
		System.out.println(realMaxPerson);
	}
}
