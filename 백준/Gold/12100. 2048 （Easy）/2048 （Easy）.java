import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int max = 0, nBoard;
	public static int[] dr = { 0, 0, 1, -1 };// 동 서 남 북
	public static int[] dc = { 1, -1, 0, 0 };
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		nBoard = Integer.parseInt(br.readLine());
		int[][] board = new int[nBoard][nBoard];
		for(int i = 0; i < nBoard; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j = 0; j < nBoard; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		game(0,board);
		
		System.out.println(max);
		
	}
	
	public static void game(int cnt, int[][] board) {
		
		if(cnt == 5) {
			int rsltTmp = 0;
			for(int i = 0; i < nBoard; i++) {
				for(int j = 0; j < nBoard; j++) {
					rsltTmp = Math.max(rsltTmp,board[i][j]);
				}
			}
			max = Math.max(max, rsltTmp);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			
			boolean[][] visit = new boolean[nBoard][nBoard];
			int[][] tmpBoard = new int[nBoard][nBoard];
			
			for(int j = 0; j < nBoard; j++) {
				for(int k = 0; k < nBoard; k++) {
					tmpBoard[j][k] = board[j][k];
				}
			}
			
			switch(i) {
			case 0:
			case 2:
				
				for( int j = nBoard-1; j >= 0; j--) {
					for(int k = nBoard; k >= 0; k--) {
						move(tmpBoard, visit, i, j, k);
					}
				}
				break;
				
			case 1:
			case 3:

				for( int j = 0; j < nBoard; j++) {
					for(int k = 0; k < nBoard; k++) {
						move(tmpBoard, visit, i, j, k);
					}
				}
				break;
				
			}
			
			game(cnt+1, tmpBoard);
		}
	}
	
	public static void move(int[][] board, boolean[][] visit, int dir, int row, int col ) {
		
		int currRow = row;
		int currCol = col;
		int nextRow = currRow + dr[dir];
		int nextCol = currCol + dc[dir];
		
		if( nextRow < 0 || nextRow >= nBoard || nextCol < 0 || nextCol >= nBoard ) {
			return;
		}
		
		boolean end = false;
		while(!end) {
			if(board[nextRow][nextCol] == 0) {
				board[nextRow][nextCol] = board[currRow][currCol];
				board[currRow][currCol] = 0;
				currRow = nextRow;
				currCol = nextCol;
				nextRow = currRow + dr[dir];
				nextCol = currCol + dc[dir];
				if( nextRow < 0 || nextRow >= nBoard || nextCol < 0 || nextCol >= nBoard ) {
					end = true;
				}
			}else if(board[nextRow][nextCol] == board[currRow][currCol]){
				if(!visit[nextRow][nextCol]) {
					board[nextRow][nextCol] *= 2;
					board[currRow][currCol] = 0;
					visit[nextRow][nextCol] = true;
				}
				end = true;
			}else {
				end = true;
			}
		}
	}
}
