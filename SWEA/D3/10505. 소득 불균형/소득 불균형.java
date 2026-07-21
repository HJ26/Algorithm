import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int [] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			arr = new int [N];
			int sum = 0;
			int avg = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			avg = sum / N;
			int res = 0;
                
			for(int i=0; i<N; i++) {
				if(arr[i] <= avg) {
					res++;
				}
			}
			
			sb.append("#"+tc+" "+res+"\n");
		}
		System.out.println(sb);
		
	}

}