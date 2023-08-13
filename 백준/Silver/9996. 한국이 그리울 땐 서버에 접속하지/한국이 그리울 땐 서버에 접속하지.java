import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 정규식 만들기
		String pattern = "^"+br.readLine()+"$";
		pattern = pattern.replaceAll("\\*",".*");
		
		// 결과 출력
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.matches(pattern)) {
				System.out.println("DA");
			}else {
				System.out.println("NE");
			}
		}
		
	}
}
