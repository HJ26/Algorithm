import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long point = 0;
		PriorityQueue<Long> cards = new PriorityQueue<Long>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			long num = Long.parseLong(st.nextToken());
			cards.add(num);
			point += num;
		}
		
		for(int i = 0; i < m; i++) {
			long min = cards.poll();
			long second = cards.poll();
			
			cards.add(min+second);
			cards.add(min+second);
			point += (min+second);
		}
		
		bw.write(Long.toString(point));
		bw.close();
		
	}
}
