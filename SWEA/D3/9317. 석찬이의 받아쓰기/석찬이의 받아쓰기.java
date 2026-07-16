import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; ++t) {
			int n = Integer.parseInt(br.readLine());
			char[] standard = br.readLine().toCharArray();
			char[] compare = br.readLine().toCharArray();
			int cnt = 0;
			for(int i=0; i<n; ++i) {
				if(standard[i] == compare[i]) {
					cnt++;
				}
			}
			bw.write("#"+t+" "+cnt+"\n");
		}
		bw.close();
		br.close();

	}

}