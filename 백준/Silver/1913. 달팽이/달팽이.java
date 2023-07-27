import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		int[] direction = {-1,1,1,-1}; // 0:위 1:오른쪽 2:아래 3: 왼쪽
		int dir = 3;
		int nextDir;
		int row = n / 2;
		int col = n / 2;
		int targetRow = 0; 
		int targetCol = 0;
		int num = 1;
		
		while(num < n*n + 1) {
			
			
			dir = dir % 4;
			nextDir = (dir+1) % 4;
			if ( num == target) {
				targetRow = row+1;
				targetCol = col+1;
			}

			switch(dir) {
			
			case 0:
			case 2:
				
				if( arr[row][col+direction[nextDir]] != 0) {
					arr[row][col] = num;
					num++;
					row += direction[dir];

				}else {
					arr[row][col] = num;
					num++;
					dir++;
					col += direction[nextDir];
				}

				break;

			
			case 1:
			case 3:
				if( arr[row+direction[nextDir]][col] != 0) {
					arr[row][col] = num;
					num++;
					col += direction[dir];
				}else {
					arr[row][col] = num;
					num++;
					dir++;
					row += direction[nextDir];
				}
				break;
				
			}		
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.write( targetRow + " " + targetCol);
		bw.close();
		
	}
}
