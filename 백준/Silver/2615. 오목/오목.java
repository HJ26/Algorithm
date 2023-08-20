import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int[][] board = new int[19][19];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 19; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}

		// 탐색
		int rowIdx = 0, colIdx = 0, target = 0;
		First: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] != 0) {
					target = board[i][j];
					if (j < 15 && checkRow(target, i, j)) {
						rowIdx = i + 1;
						colIdx = j + 1;
						break First;
					} else if (i < 15 && checkCol(target, i, j)) {
						rowIdx = i + 1;
						colIdx = j + 1;
						break First;
					} else if (i < 15 && j < 15 && checkDiagRight(target, i, j)) {
						rowIdx = i + 1;
						colIdx = j + 1;
						break First;
					} else if (i < 15 && j > 3 && checkDiagLeft(target, i, j)) {
						rowIdx = i + 5;
						colIdx = j - 3;
						break First;
					}
					target = 0;
				}
			}
		}

		sb.append(target).append("\n");
		if (target != 0)
			sb.append(rowIdx).append(" ").append(colIdx);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	public static boolean checkRow(int target, int row, int col) {

		// 오목 확인
		for (int i = 1; i < 5; i++) {
			if (board[row][col + i] != target) {
				return false;
			}
		}

		// 육목 확인
		if ( ( col + 5 < 19 && board[row][col + 5] == target) ||
			 ( col - 1 >= 0 && board[row][col-1] == target	)   ){
			return false;
		}

		return true;
	}

	public static boolean checkCol(int target, int row, int col) {

		for (int i = 1; i < 5; i++) {
			if (board[row + i][col] != target) {
				return false;
			}
		}
		// 육목 확인
		if ( ( row + 5 < 19 && board[row+5][col] == target) ||
		     ( row - 1 >= 0 && board[row-1][col] == target	)   ){
				return false;
			}

		return true;
	}

	public static boolean checkDiagRight(int target, int row, int col) {

		// 왼 -> 오 방향으로 내려가는 대각선
		for (int i = 1; i < 5; i++) {
			if (board[row + i][col + i] != target) {
				return false;
			}
		}

		// 육목 확인
		if ( ( row + 5 < 19 && col + 5 < 19 && board[row+5][col+5] == target) ||
			 ( row - 1 >= 0 && col - 1 >= 0 && board[row-1][col-1] == target	)   ){
				return false;
			}

		return true;
	}

	public static boolean checkDiagLeft(int target, int row, int col) {

		// 오 -> 왼 방향으로 내려가는 대각선
		for (int i = 1; i < 5; i++) {
			if (board[row + i][col - i] != target) {
				return false;
			}
		}
		// 육목 확인
		if ( ( row + 5 < 19 && col - 5 >= 0 && board[row+5][col-5] == target) ||
		     ( row - 1 >= 0 && col + 1 < 19 && board[row-1][col+1] == target	)   ){
				return false;
			}

		return true;
	}

}
