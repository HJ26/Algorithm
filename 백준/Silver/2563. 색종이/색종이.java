import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] white = new int[100][100];
		int nBlack = Integer.parseInt(br.readLine());
		// 검은색 크기만큼 칠하기
		int cnt = 0;
		for(int i = 0; i < nBlack; i++) {
			String[] tmp = br.readLine().split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			for(int j = x; j < x+10; j++) {
				for(int k = y; k < y+10; k++) {
					if(white[j][k] != 1) {
						cnt++;
						white[j][k] = 1;
						
					}
				}
			}
		}
		System.out.println(cnt);
		
	}
}
