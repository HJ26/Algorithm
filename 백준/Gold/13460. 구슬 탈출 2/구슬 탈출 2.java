import java.io.*;
import java.util.*;

public class Main {
	static int NR, NC, redR, redC, blueR, blueC, nextRedR, nextRedC, nextBlueR, nextBlueC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int isSuccess = -1;

	static class Gu {
		int redR, redC, blueR, blueC, nMove;

		public Gu() {
		}

		public Gu(int redR, int redC, int blueR, int blueC, int nMove) {
			this.redR = redR;
			this.redC = redC;
			this.blueR = blueR;
			this.blueC = blueC;
			this.nMove = nMove;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st;

		// 데이터 입력받기
		st = br.readLine().split(" ");
		NR = Integer.parseInt(st[0]);
		NC = Integer.parseInt(st[1]);
		map = new int[NR][NC];
		for (int r = 0; r < NR; r++) {
			st = br.readLine().split("");
			for (int c = 0; c < NC; c++) {
				switch (st[c]) {
				case "#": // 벽 = 갈 수 없는 곳
					map[r][c] = -1;
					break;
				case "B": // 파란 구슬 = 넣으면 안됨
					blueR = r;
					blueC = c;
					break;
				case "R": // 빨간 구슬 = 넣어야 됨
					redR = r;
					redC = c;
					break;
				case "O": // 구멍 = 목표 위치
					map[r][c] = 5;
					break;
				}

			}
		}

		// 구슬 움직이기
		tilt();

		// 성공여부 출력
		System.out.println(isSuccess);
	}

	private static void tilt() {

		Queue<Gu> que = new LinkedList<Main.Gu>();
		que.add(new Gu(redR, redC, blueR, blueC, 0));

		while (!que.isEmpty()) {
			Gu currGu = que.poll();
			
			// 현재 위치에서 10번 다 이동했으면 종료
			if (currGu.nMove == 10) return;
			
			// 4방향으로 기울이기
			for (int dir = 0; dir < 4; dir++) {

				// 구슬 위치 업데이트
				nextRedR = currGu.redR;
				nextRedC = currGu.redC;
				nextBlueR = currGu.blueR;
				nextBlueC = currGu.blueC;

				// 다음 구슬 위치 받아오기
				if (!move(dir, currGu))
					continue;

				// 빨간 구슬이 이동중에 탈출했으면 종료
				if (isSuccess != -1)
					return;

				// 큐에 추가
				que.add(new Gu(nextRedR, nextRedC, nextBlueR, nextBlueC, currGu.nMove + 1));
			}
		}
	}

	private static boolean move(int dir, Gu curr) {

		boolean redFlag, blueFlag;
		int[][] mapTmp = new int[NR][NC];
		for(int i = 0; i < NR; i++) {
			for(int j = 0; j < NC; j++) {
				mapTmp[i][j] = map[i][j];
			}
		}
		
		mapTmp[nextRedR][nextRedC] = 1;
		mapTmp[nextBlueR][nextBlueC] = 2;
		
		while (true) {

			redFlag = false;
			blueFlag = false;

			// 다음 위치가 빈 공간이거나 구멍이면 이동
			if (mapTmp[nextBlueR + dr[dir]][nextBlueC + dc[dir]] == 0 || mapTmp[nextBlueR + dr[dir]][nextBlueC + dc[dir]] == 5) {
				
				blueFlag = true;					// 이동했다고 표시
				mapTmp[nextBlueR][nextBlueC] = 0;		// 원 위치 0으로 변경
				nextBlueR = nextBlueR + dr[dir];	// 이동
				nextBlueC = nextBlueC + dc[dir];

				// 구멍 통과 여부 판단
				// 파란 구슬이 구멍을 통화했으면 이동 실패
				if (mapTmp[nextBlueR][nextBlueC] == 5) {
					isSuccess = -1;
					return false;
				}
				mapTmp[nextBlueR][nextBlueC] = 2;		// 구멍을 통과한게 아니면 이동 완료

			}

			// 내 위치가 구멍이 아니고, 다음 위치가 빈 공간이거나 구멍이면 이동
			if (mapTmp[nextRedR][nextRedC] != 5 && mapTmp[nextRedR + dr[dir]][nextRedC + dc[dir]] == 0 || mapTmp[nextRedR + dr[dir]][nextRedC + dc[dir]] == 5) {
				redFlag = true;					// 이동했다고 표시
				mapTmp[nextRedR][nextRedC] = 0;	// 원 위치 빈 공간으로 이동
				nextRedR = nextRedR + dr[dir];	// 이동
				nextRedC = nextRedC + dc[dir];

				// 구멍 통과 여부 판단
				if (mapTmp[nextRedR][nextRedC] == 5) {
					isSuccess = curr.nMove + 1;	// 구멍에 도달했으면 이동횟수 갱신
				}
				else mapTmp[nextRedR][nextRedC] = 1;								// 도달 안했으면 이동 종료

			}

			// 둘 다 이동 안했으면 종료
			if (!redFlag && !blueFlag) break;

		}
		return true;
	}
}
