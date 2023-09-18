import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int nBoard, size, nFish, distance;
	public static int[] shark;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		nBoard = Integer.parseInt(br.readLine());
		board = new int[nBoard][nBoard];

		// 물고기 위치 정보 저장
		StringTokenizer st;
		for (int i = 0; i < nBoard; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < nBoard; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) {
					shark = new int[] { i, j }; // 상어가 있는 위치
					board[i][j] = 0;
				}
			}
		}

		size = 2;
		nFish = 0;
		distance = 0;
		BFS();
		bw.write(Integer.toString(distance));
		bw.close();
		br.close();

	}

	public static void BFS() {

		while (true) {
			PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> 
					o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));
			
			boolean[][] visit = new boolean[nBoard][nBoard];

			que.add(new int[] { shark[0], shark[1], 0 });
			visit[shark[0]][shark[1]] = true;

			boolean isEat = false;

			while (!que.isEmpty()) {
				shark = que.poll();
				int currX = shark[0];
				int currY = shark[1];
				int dist = shark[2];
				if (board[currX][currY] != 0 && board[currX][currY] < size) {
					board[currX][currY] = 0;
					nFish++;
					distance += dist;
					isEat = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nextX = currX + dx[i];
					int nextY = currY + dy[i];
					if (nextX < 0 || nextX >= nBoard || nextY < 0 || nextY >= nBoard || visit[nextX][nextY] || board[nextX][nextY] > size)
						continue;

					que.add(new int[] { nextX, nextY, dist + 1 });
					visit[nextX][nextY] = true;
				}
			}

			if (!isEat) return;
			
			if (size == nFish) {
				size++;
				nFish = 0;
			}
		}

	}
}