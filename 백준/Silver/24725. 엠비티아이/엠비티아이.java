import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NS = br.readLine().split(" ");
		int row = Integer.parseInt(NS[0]);
		int col = Integer.parseInt(NS[1]);
		String[][] board = new String[row][col];

		// 방향
		int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상 하 좌 우 좌상 우상 좌하 우하
		int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
		int dir = 0;
		int rslt = 0;

		// 판 만들기
		for (int i = 0; i < row; i++) {
			board[i] = br.readLine().split("");
		}

		// 판 탐색
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				dir = 0;
				if (board[i][j].equals("I") || board[i][j].equals("E")) {

					int curRow = i;
					int curCol = j;

					while (dir < 8) {
						// 두번째 글자 찾기
						if ((curRow + dr[dir]) >= 0 && (curRow + dr[dir]) < row && (curCol + dc[dir]) >= 0
								&& (curCol + dc[dir]) < col && (board[curRow + dr[dir]][curCol + dc[dir]].equals("N")
										|| board[curRow + dr[dir]][curCol + dc[dir]].equals("S"))) {
							curRow = curRow + dr[dir];
							curCol = curCol + dc[dir];

							// 세번째 글자 찾기
							if ((curRow + dr[dir]) >= 0 && (curRow + dr[dir]) < row && (curCol + dc[dir]) >= 0
									&& (curCol + dc[dir]) < col
									&& (board[curRow + dr[dir]][curCol + dc[dir]].equals("F")
											|| board[curRow + dr[dir]][curCol + dc[dir]].equals("T"))) {
								curRow = curRow + dr[dir];
								curCol = curCol + dc[dir];

								// 마지막 글자 찾기
								if ((curRow + dr[dir]) >= 0 && (curRow + dr[dir]) < row && (curCol + dc[dir]) >= 0
										&& (curCol + dc[dir]) < col
										&& (board[curRow + dr[dir]][curCol + dc[dir]].equals("P")
												|| board[curRow + dr[dir]][curCol + dc[dir]].equals("J"))) {
									rslt++;
									curRow = i;
									curCol = j;
									dir++;
								} else {
									curRow = i;
									curCol = j;
									dir++;
								}
							} else {
								curRow = i;
								curCol = j;
								dir++;
							}

						} else {
							curRow = i;
							curCol = j;
							dir++;
						}
					}

				}
			}
		}
		System.out.println(rslt);

	}
}
