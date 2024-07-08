import java.io.*;
import java.util.*;

public class Main {
	
	static class Number implements Comparable<Number>{
		
		long origin;
		long abs;
		
		public Number(long origin, long abs) {
			this.origin = origin;
			this.abs = abs;
		}

		@Override
		public int compareTo(Number o) {
			if(o.abs == this.abs) return (int) (this.origin - o.origin);
			return (int) (this.abs - o.abs);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Number> heap = new PriorityQueue<Number>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			if(num != 0) {
				heap.add(new Number(num, Math.abs(num)));
			}else {
				if(heap.size() != 0) {
					sb.append(heap.poll().origin);					
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
