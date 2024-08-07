import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(q.size() == n) {
					if(q.peek() < num) {
						q.poll();
						q.add(num);
					}
				}else {
					q.add(num);
				}
			}
		}
		bw.write(Integer.toString(q.poll()));
        bw.close();
        br.close();
	}
}