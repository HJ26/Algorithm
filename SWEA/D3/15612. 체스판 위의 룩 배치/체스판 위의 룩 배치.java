import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			boolean[] row = new boolean[8];
			boolean[] column = new boolean[8];
			boolean isBreak = false;
			
			for (int x=0; x<8; x++) {
				String line = br.readLine();
				
				if (isBreak) continue;
				
				for(int y=0;  y<8;  y++) {
					char elem = line.charAt(y);
					
					if (elem == '.') continue;
					
					if (row[x] || column[y]) {
						System.out.printf("#%d no\n", tc);
						isBreak = true;
						break;
					}
					
					row[x] = true;
					column[y] = true;
				}
			}
			
			if (!isBreak) {
				String answer = "yes";
				
				for (int i=0; i<8; i++) {
					if (row[i] == false || column[i] == false) {
						answer = "no";
					}
				}
				
				System.out.printf("#%d %s\n", tc, answer);
			}
		}
	}
}