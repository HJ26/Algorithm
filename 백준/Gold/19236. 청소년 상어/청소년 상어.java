import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	// 상어 클래스
	static class Shark {
		int x, y, dir, totalScore;

		public Shark() {
		}

		public Shark(int x, int y, int dir, int totalScore) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.totalScore = totalScore;

		}
	}

	// 물고기 클래스
	static class Fish implements Comparable<Fish> {
		int x, y, score, dir;
		boolean isEat;

		public Fish() {
			// TODO Auto-generated constructor stub
		}

		public Fish(int x, int y, int score, int dir, boolean isEat) {
			this.x = x;
			this.y = y;
			this.score = score;
			this.dir = dir;
			this.isEat = isEat;
		}

		@Override
		public int compareTo(Fish o) {
			return this.score - o.score;
		}

	}

	// 전역변수
	static int maxScore = 0; // 최대 점수
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 상 방향 부터 반시계방향
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 }; // 상 방향 부터 반시계방향

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 지도 정보를 저장할 배열
		int[][] map = new int[4][4];

		// 물고기 정보를 저장할 리스트 생성
		List<Fish> fishes = new ArrayList<>();

		// 입력 받기
		String[] inputTmp;
		for (int i = 0; i < 4; i++) {
			inputTmp = br.readLine().split(" ");
			for (int j = 0,idx = 0; j < 4; j++, idx += 2) {
				int score = Integer.parseInt(inputTmp[idx]);
				int dir = Integer.parseInt(inputTmp[idx+1]) - 1;
				fishes.add(new Fish(i, j, score, dir, false)); // 물고기 정보 생성

				map[i][j] = score; // 지도에 정보 저장
			}
		}

		// 점수 순서대로 정렬
		Collections.sort(fishes);

		// 상어 정보 생성
		Fish firstFish = fishes.get(map[0][0] - 1);
		Shark shark = new Shark(0, 0, firstFish.dir, firstFish.score);
		firstFish.isEat = true;
		map[0][0] = -1; // 현재 상어의 위치

		// 점수 구하기
		moveShark(shark, map, fishes);

		// 최대값 출력
		bw.write(Integer.toString(maxScore));
		bw.close();
		br.close();

	}

	private static void moveShark(Shark shark, int[][] map, List<Fish> fishes) {

		// 최대값 구하기
		maxScore = Math.max(maxScore, shark.totalScore);

		// 물고기 움직이기
		for (Fish fish : fishes) {
			moveFish(fish, map, fishes);
		}

		// 상어 움직이기
		// 같은 방향으로 1~4칸까지 이동해보기
		for (int nMove = 1; nMove < 4; nMove++) {

			int nextX = shark.x + dx[shark.dir] * nMove;
			int nextY = shark.y + dy[shark.dir] * nMove;

			// 다음에 이동할 칸이 맵 밖이거나 물고기가 없으면 다음 칸 탐색
			if (0 > nextX || nextX >= 4 || 0 > nextY || nextY >= 4 || map[nextX][nextY] <= 0) continue;
			

			// 물고기 정보 바꾸고 다음 탐색

			// 재귀 이므로 다음에 영향을 받지 않기 위해 복사본을 만든 후 이를 전달

			// 지도 복사
			int[][] mapTmp = new int[4][4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++)
					mapTmp[i][j] = map[i][j];
			}

			// 물고기 복사
			List<Fish> fishTmp = new ArrayList<>();
			for (Fish f : fishes)
				fishTmp.add(new Fish(f.x, f.y, f.score, f.dir, f.isEat));

			// 복사본에서 물고기 정보 바꾸고 넘기기 ( 상어가 먹기 )
			Fish f = fishTmp.get(map[nextX][nextY] - 1);
			Shark nextShark = new Shark(f.x, f.y, f.dir, shark.totalScore + f.score);
			f.isEat = true;

			// 상어 위치 업데이트
			mapTmp[shark.x][shark.y] = 0; // 이동했으므로 먹힌 물고기가 되어서 0으로 변경
			mapTmp[f.x][f.y] = -1; // 새로운 상어의 위치값을 -1로 변경
			
			moveShark(nextShark, mapTmp, fishTmp);
		}
	}

	// 물고기 이동시키기
	private static void moveFish(Fish fish, int[][] map, List<Fish> fishes) {

		// 먹힌 물고기면 종료
		if (fish.isEat)
			return;

		// 8방 탐색하면서 바꿀 수 있는 물고기가 있는지 확인 후 변경
		for (int i = 0; i < 8; i++) {
			int dir = (fish.dir + i) % 8;
			int nextX = fish.x + dx[dir];
			int nextY = fish.y + dy[dir];

			// 이동할 방향이 맵 밖이거나 상어라면 다음 방향 탐색
			if (0 > nextX || nextX >= 4 || 0 > nextY || nextY >= 4 || map[nextX][nextY] <= -1)
				continue;

			// 이동할 수 있다면 이동

			// 현재 위치 0으로 바꾸기
			map[fish.x][fish.y] = 0;

			// 움직이려는 위치가 빈칸이면 그냥 가기만 하기
			if (map[nextX][nextY] == 0) {
				fish.x = nextX;
				fish.y = nextY;
			} else { // 빈칸이 아니면 바꾸기

				// 바꾸려는 위치의 물고기 정보 가져오기
				Fish fishTmp = fishes.get(map[nextX][nextY] - 1);
				fishTmp.x = fish.x; // 좌표 위치 교환
				fishTmp.y = fish.y;
				map[fish.x][fish.y] = fishTmp.score; // 지도에 점수 정보 변경

				fish.x = nextX;
				fish.y = nextY;
			}

			map[nextX][nextY] = fish.score; // 현재 물고기 위치 변경
			fish.dir = dir; // 방향을 지금 이동한 방향으로 바꾸기
			return;
		}

	}

}
