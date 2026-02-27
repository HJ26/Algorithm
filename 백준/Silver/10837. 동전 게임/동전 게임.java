import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
 
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int K = Integer.parseInt(br.readLine());
		int TC = Integer.parseInt(br.readLine());
 
		for(int i = 0; i < TC; i++) {
			String [] arr = br.readLine().split(" ");
			int youngM = Integer.parseInt(arr[0]);
	
			int dongN = Integer.parseInt(arr[1]);

			int gap = Math.abs(youngM - dongN);

			int nmg = K - (youngM > dongN ? youngM : dongN);
			
			if(youngM == dongN) {
				System.out.println(1);
			}else if(youngM > dongN) {
				if(gap - nmg <= 2)System.out.println(1);
				else System.out.println(0);
				
			}else {
				if(gap - nmg <= 1) System.out.println(1);
				else System.out.println(0);
			}
		}
		
	}
 
    }