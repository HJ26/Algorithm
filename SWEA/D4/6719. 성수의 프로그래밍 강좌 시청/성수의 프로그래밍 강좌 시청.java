import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		int K = 0;
		double result = 0;
		String[] s;
		int[] arr;
		for(int tc=1; tc<=T; tc++) {
			result = 0;
			s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			K = Integer.parseInt(s[1]);
			s = br.readLine().split(" ");
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			Arrays.sort(arr);
			for(int i=arr.length-K; i<arr.length; i++) {
				result = (result+arr[i])/2;
			}
			sb.append("#"+tc+" "+result+"\n");
		}
        System.out.println(sb);
	}
}