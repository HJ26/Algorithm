import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
		
        for(int tc=1; tc<=T; tc++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int[] dia = new int[10001];
			int max = 0;
			int min = 10001;
			for(int i=0; i<n; ++i) {
				int size = Integer.parseInt(br.readLine());
				if(max < size) {
					max = size;
				}
				if(min > size) {
					min = size;
				}
				dia[size]++;
			}
			int result = 0;
			for(int i=min; i<max+1; ++i) {
				int sum = 0;
				for(int j=i; j<(i+k+1 > 10001? 10001 : i+k+1); ++j) {
					sum += dia[j];
				}
				if(sum > result) {
					result = sum;
				}
			}
			sb.append("#"+tc+" "+result+"\n");
		}
		System.out.println(sb);
    }
}