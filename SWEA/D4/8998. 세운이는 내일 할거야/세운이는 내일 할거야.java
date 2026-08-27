import java.io.*;
import java.util.*;

class Solution {
	

	static PriorityQueue<int[]> assignments = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] i1, int[] i2) {
			return i2[1] - i1[1];
		}
	});
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			assignments.clear();
		
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				assignments.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			int assignment[] = assignments.poll();
			int startTime = assignment[1] - assignment[0];
			while (!assignments.isEmpty()) {
				assignment = assignments.poll();
				if (startTime < assignment[1])
					startTime -= assignment[0];
				else
					startTime = assignment[1] - assignment[0];
			}
			bw.write("#" + test_case + " " + startTime + "\n");
		}bw.close();
	}
}