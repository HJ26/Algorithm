import java.io.*;
import java.util.*;


class Solution {
		public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int N, cnt = 0;
		StringTokenizer st;
		for (int tc = 1; tc <= TC; tc++) {
			cnt = 0;
			N = Integer.parseInt(br.readLine());
			int[][] line = new int [N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				line[i][0] = Integer.parseInt(st.nextToken());
				line[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(line, (o1, o2) -> {
				if (o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				} else {
					return Integer.compare(o1[0], o2[0]);
				}
			});
			
			for (int i = 0; i < line.length-1; i++) {
				for (int j = i+1; j < line.length; j++) {
					if(line[i][0] == line[j][0] || line[i][1] >= line[j][1]) 
						cnt++; 
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}