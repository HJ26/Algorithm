import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int strLen = str.length();
		List<String> arr = new ArrayList<>();
		
		StringBuffer fb, sb, lb;
		
		for(int i = 1; i < strLen; i++) {
			for(int j = i+1; j < strLen; j++) {
				
				String tmp = "";
				fb = new StringBuffer(str.substring(0,i));
				sb = new StringBuffer(str.substring(i,j));
				lb = new StringBuffer(str.substring(j));
				tmp += fb.reverse().toString();
				tmp += sb.reverse().toString();
				tmp += lb.reverse().toString();
			
				arr.add(tmp);
			}
		}
		
		Collections.sort(arr);
		bw.write(arr.get(0));
		bw.close();
	}
}
