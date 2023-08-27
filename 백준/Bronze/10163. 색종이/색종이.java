import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nPaper = Integer.parseInt(br.readLine());
		int[][] board = new int[1001][1001];
		int[] cnt = new int[nPaper+1];
		for(int i = 1; i < nPaper+1; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			int width = Integer.parseInt(input[2]);
			int height = Integer.parseInt(input[3]);
			
			for(int j = x; j < x+width; j++) {
				for(int k = y; k < y+height; k++) {
					cnt[board[j][k]]--;
					cnt[i]++;
					board[j][k] = i;
				}
			}
		}
		
		for(int i = 1; i < nPaper+1; i++) {
			System.out.println(cnt[i]);
		}
	}
}
