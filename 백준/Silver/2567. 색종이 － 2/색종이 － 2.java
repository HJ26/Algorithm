import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] white = new int[101][101];
		int nPaper = Integer.parseInt(br.readLine());
		
		// 사각형 부분 구하기
		for(int i = 0; i < nPaper; i++) {
			String[] tmp = br.readLine().split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			for(int j = x; j < x+10; j++) {
				for(int k = y; k < y+10; k++) {
						white[j][k] = 1;
				}
			}
		}

		// 넓이 구하기
		int[] dx = { 0, 1, 0, -1};
		int[] dy = { 1, 0, -1, 0};
		int cnt = 0;
		for(int i =0 ; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(white[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						if(white[i+dx[k]][j+dy[k]] != 1) {
							cnt++;
						}
					}
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}
