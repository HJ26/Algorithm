import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Long> heap = new PriorityQueue<Long>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			if(num != 0) {
				heap.add(num);
			}else {
				if(heap.size() != 0) {
					sb.append(heap.poll());					
				}else {
					sb.append("0");
				}
				sb.append("\n");			
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
