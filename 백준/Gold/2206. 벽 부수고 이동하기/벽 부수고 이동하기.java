import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Place {
	int x;
	int y;
	int crush;
	int move;

	Place(int x, int y, int crush, int move) {
		this.x = x;
		this.y = y;
		this.crush = crush;
		this.move = move;
	}

}

public class Main {

	public static int N;
	public static int M;
	public static int[][] board;
	public static boolean[][][] visit;
	public static int nMove;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		visit = new boolean[N][M][2];
		nMove = -1;

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(input[j]);
			}
		}
		BFS();
		System.out.println(nMove);

	}

	public static void BFS() {
		Queue<Place> que = new LinkedList<>();
		que.add(new Place(0, 0, 0, 1));

		while (!que.isEmpty()) {
			Place place = que.poll();
			int x = place.x;
			int y = place.y;
			int crush = place.crush;
			int move = place.move;
			
			// 현재 점이 마지막 점이면 멈추기
			if( x == N-1 && y == M-1 ) {
				nMove = move;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				// 배열의 범위에 속하는 경우
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;

                // 벽을 만난 경우
                if (board[nextX][nextY] == 1) {
                    if (crush == 0) {
                        que.add(new Place(nextX, nextY, 1, move + 1));
                    }
                }else { // 벽을 만나지 않은 경우
                    if (!visit[nextX][nextY][crush]) {
                        que.add(new Place(nextX, nextY, crush, move + 1));
                        visit[nextX][nextY][crush] = true;
                    }
                }
            }
		}
	}
}
