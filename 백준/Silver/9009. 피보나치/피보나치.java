import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int [] fibo = new int[46];
		fibo[1] = 1;
		for(int i=2;i<=45;i++) //fibo[45]=1,134,903,170
			fibo[i] = fibo[i-1] + fibo[i-2]; 
		
		int T = Integer.parseInt(br.readLine());
		int n;
		
		LinkedList<Integer> stack;
		
		for(int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			stack = new LinkedList<Integer>();
			
			for(int i=45;i>0;i--) {
				if(n>=fibo[i]) {
					n-=fibo[i];
					stack.addLast(fibo[i]);
				}
				if(n==0) break;
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.removeLast()+" ");
			}
			sb.append("\n");
		}
        System.out.println(sb.toString());
	}
}