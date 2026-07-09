import java.io.*;
import java.util.*;

public class Solution {
	
	public static double[] r = new double[] {Math.pow(20,2), 
			Math.pow(40,2), Math.pow(60,2), Math.pow(80,2),
			Math.pow(100,2), Math.pow(120,2), Math.pow(140,2),
			Math.pow(160,2), Math.pow(180,2), Math.pow(200,2)};
	
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc <= T; tc++) {
            
			int N = Integer.parseInt(br.readLine());
			
			int score = 0;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				
				for(int j=0; j<10; j++) {
					if(Math.pow(x, 2) + Math.pow(y, 2) <= r[j]) {
						score += (10 - j); 
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + score);
		}
	}
}