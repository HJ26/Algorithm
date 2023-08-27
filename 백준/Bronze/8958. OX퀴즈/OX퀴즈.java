import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {			
			String rslt = br.readLine();
			int point = 0;
			int cnt = 0;
			for(int i =0; i < rslt.length(); i++) {
				if(rslt.charAt(i) == 'O') {
					cnt++;
					point += cnt;
				}else {
					cnt = 0;
				}
			}
			
			System.out.println(point);
		}
	}
}
