import java.io.*;
import java.util.*;

public class Main {
	static int N, K, L, TIME;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int[][] map;
	static int[][] rotation;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];

		// 사과 위치 세팅
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}

		// 회전 정보 받기
		L = Integer.parseInt(br.readLine());
		rotation = new int[L][2];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			rotation[i][0] = Integer.parseInt(st.nextToken());
			rotation[i][1] = st.nextToken().equals("D") ? 1 : -1;
		}

		// 게임 시작
		map[0][0] = 2;
		TIME = 0;
		startGame();

		// 출력
		System.out.println(TIME);
	}

	private static void startGame() {
		Deque<int[]> snakePlace = new LinkedList<>();
		snakePlace.add(new int[] { 0, 0 });

		int dir = 1, currR, currC, nextR, nextC, idx = 0;
		int[] curr;
		while (!snakePlace.isEmpty()) {

			TIME++;
			
			curr = snakePlace.peekLast();
			currR = curr[0];
			currC = curr[1];

			nextR = currR + dr[dir];
			nextC = currC + dc[dir];

			// 벽이나 몸에 부딪히면 return
			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || map[nextR][nextC] == 2) {
				return;
			}

			// 이동하고 사과를 못먹으면 길이 줄이기
			if (map[nextR][nextC] != 1) {
				int[] start = snakePlace.pollFirst();
				map[start[0]][start[1]] = 0;
			}
			snakePlace.add(new int[] { nextR, nextC });
			map[nextR][nextC] = 2;


			// 시간이 되면 방향 바꾸기
			if (idx < L && TIME == rotation[idx][0]) {
				dir += rotation[idx++][1];
				if (dir < 0)
					dir = 3;
				if (dir >= 4)
					dir = 0;
			}

		}

	}

}
