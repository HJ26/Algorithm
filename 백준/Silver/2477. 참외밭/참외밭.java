import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int nMelon = Integer.parseInt(br.readLine());
		int[][] dirLen = new int[6][6];
		int[] cnt = new int[4];
		
		for(int i = 0; i < 6; i++) {
			String[] temp = br.readLine().split(" ");
			dirLen[i][0] = Integer.parseInt(temp[0]);
			dirLen[i][1] = Integer.parseInt(temp[1]);
			cnt[dirLen[i][0]-1]++;
		}
		
		// 큰 가로 세로 구하기
		int bigRow = 0, bigCol = 0, smallRow = 0, smallCol = 0;
		for(int i = 0; i < 6; i++) {
			switch(dirLen[i][0]) {
			case 1:
			case 2:
				if( cnt[ dirLen[i][0]-1 ] == 1) bigRow = dirLen[i][1];
				else {
					if(i > 0 && i < 5) {
						if(dirLen[i-1][0] == dirLen[i+1][0])
							smallRow = dirLen[i][1];	
					}else if( i == 0 ) {
						if(dirLen[5][0] == dirLen[1][0])
							smallRow = dirLen[i][1];
					}else {
						if(dirLen[4][0] == dirLen[0][0])
							smallRow = dirLen[i][1];
					}
				}
				break;
			case 3:
			case 4:
				if( cnt[ dirLen[i][0]-1 ] == 1) bigCol = dirLen[i][1];
				else {
					if(i > 0 && i < 5) {
						if(dirLen[i-1][0] == dirLen[i+1][0])
							smallCol = dirLen[i][1];	
					}else if( i == 0 ) {
						if(dirLen[5][0] == dirLen[1][0])
							smallCol = dirLen[i][1];
					}else {
						if(dirLen[4][0] == dirLen[0][0])
							smallCol = dirLen[i][1];
					}
				}
				break;
			}
		}
		
		
		// 넓이 구하기
		int area = (bigRow*bigCol)-(smallRow*smallCol);
		bw.write(Integer.toString(area*nMelon));
		bw.flush();
		
		
	}
}
