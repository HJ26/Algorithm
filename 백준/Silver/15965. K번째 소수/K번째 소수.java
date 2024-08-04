import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		int maxNum = 10000001;
		boolean[] nums = new boolean[maxNum];
		
		int idx = 1;
		for(int i = 2; i < maxNum; i++) {
			
			if(nums[i]) continue;
			
			if(idx == K) {
				System.out.println(i);
				break;
			}
			
			idx++;
			for(int j = i*2 ; j < maxNum; j += i) {
				nums[j] = true;
			}
		}
		
	
	}	
}
