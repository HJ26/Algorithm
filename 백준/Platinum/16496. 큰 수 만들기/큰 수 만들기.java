import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] nums = br.readLine().split(" ");
		Arrays.sort(nums, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				int idx = 0;
				int len = Math.min(o1.length(), o2.length());
				while( idx < len && o1.charAt(idx)==o2.charAt(idx)) {
					idx++;
				}
				if( o1.equals(o2) ) {
					return 0;
				}
				if( idx == len) {
					return compare(o1+o2, o2+o1);
				}
				return o2.charAt(idx) - o1.charAt(idx);
			}

		
		});
	
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(nums[i]);
		}
		
		if(nums[0].equals("0")) {
			sb = new StringBuilder();
			sb.append(0);
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}