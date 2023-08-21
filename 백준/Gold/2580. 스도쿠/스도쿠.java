import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int[][] board = new int[9][9];
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static boolean flag = false;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 보드 채우기
		for (int i = 0; i < 9; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(str[j]);
			}
		}

		sudoku(0, 0);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

// 숫자 채우기
	public static void sudoku(int row, int col) throws IOException {
		if (row == 9) {
			flag = true;
			return;
		} else if (col == 9) {
			sudoku(row + 1, 0);
			return;
		} else {
			if (board[row][col] == 0) {
				for (int i = 1; i < 10; i++) {
					if (isPlace(i, row, col)) {
						board[row][col] = i;
						sudoku(row, col + 1);
						if(flag) return;
						board[row][col] = 0;
					}
				}
				return;
			} else {
				sudoku(row, col + 1);
				if(flag) return;
			}
		}
	}

// 숫자가 있어도 되는 위치인지 확인
	public static boolean isPlace(int num, int row, int col) {

		int target = num;

		// 행열탐색
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == target) {
				return false;
			}
			if (board[i][col] == target) {
				return false;
			}
		}

		// 블록 탐색
		int rowBlock = row / 3;
		int colBlock = col / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[rowBlock * 3 + i][colBlock * 3 + j] == target) {
					return false;
				}
			}
		}

		return true;
	}
}