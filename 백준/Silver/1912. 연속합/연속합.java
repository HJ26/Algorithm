import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static Integer[] dp;
	static int N;
	static int max = Integer.MIN_VALUE;
	static int temp = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new Integer[N];
		
		for(int i = 0 ; st.hasMoreTokens() ; i ++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		dp[0] = arr[0];
		max = arr[0];
		sum(N-1);
		
        bw.write(Integer.toString(max));
        bw.close();
}
	public static int sum(int num) {
				
		if(dp[num]==null) {
			dp[num] = Math.max(sum(num-1)+arr[num] , arr[num]);
			
			max = Math.max(max, dp[num]);
		}
		
		return dp[num];
	}

}