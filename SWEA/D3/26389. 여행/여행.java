import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
        
		for(int tc=0; tc<TC; tc++) {
            
			String line = br.readLine();
			boolean e = false, w = false, s = false, n = false;
			for(int i=0; i<line.length(); i++) {
				if(line.charAt(i) == 'E') e = true;
				else if(line.charAt(i) == 'W') w = true;
				else if(line.charAt(i) == 'S') s = true;
				else n = true;
			}
            
			if((e && !w) || (w && !e) || (s && !n ) || (n && !s)) {
				sb.append("No");
			} else sb.append("Yes");
            
			sb.append("\n");
		}
        
		System.out.print(sb);
	}
}