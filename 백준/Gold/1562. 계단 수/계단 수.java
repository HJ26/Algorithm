import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long nStair = 0;
		int N = Integer.parseInt(br.readLine());
		
		long mod = 1000000000;
		long[][][] stairs = new long[N+1][10][1<<10];
		
		// 1 자리수는 모두 계단수이므로 이를 저장
		for(int i = 1; i < 10; i++) {
			stairs[1][i][1 << i] = 1;
		}
		
		// n 자리 계단수 = n-1 자리 계단수 + 숫자
		for(int i = 2; i < N+1; i++) {		// 1은 무조건 계단수가 안되니까 2부터 시작
			for(int j = 0; j < 10; j++ ) {
				for(int k = 0; k < (1<<10); k++) {
					int bit = k | (1 << j );
					if(j == 0) {
						stairs[i][0][bit] = (stairs[i][0][bit] + stairs[i-1][1][k]) % mod;
					}else if(j == 9) {
						stairs[i][9][bit] = (stairs[i][9][bit] + stairs[i-1][8][k]) % mod;
					}else {
						stairs[i][j][bit] = (stairs[i][j][bit] + stairs[i-1][j-1][k] + stairs[i-1][j+1][k]) % mod;
					}
				}
			}
		}
		
		// 0~9가 모두 쓰인 계인 계단 수 더하기
		for(int i = 0; i < 10; i++) {
			nStair += stairs[N][i][(1 << 10)-1] % mod;
			nStair %= mod;
		}

		bw.write(nStair + "\n");
		bw.close();
		br.close();
	}
}
