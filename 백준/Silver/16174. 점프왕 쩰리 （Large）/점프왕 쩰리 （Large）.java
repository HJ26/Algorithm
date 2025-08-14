import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int map[][];
	static int dr[] = { 1, 0 };
	static int dc[] = { 0, 1 };
	static int N;
	static boolean visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(new Point(0, 0));
		System.out.println("Hing");
	}

	static void dfs(Point p) {
		int jump = map[p.x][p.y];
		if (jump == -1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}

		for (int i = 0; i < 2; i++) {
			int row = p.x + dr[i] * jump;
			int col = p.y + dc[i] * jump;

			if (row < 0 || col < 0 || row >= N || col >= N)
				continue;
			if (visit[row][col])
				continue;

			visit[row][col] = true;
			dfs(new Point(row, col));
		}

	}

}