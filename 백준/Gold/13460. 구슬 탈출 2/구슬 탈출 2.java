import java.io.*;
import java.util.*;

public class Main {
	static int NR, NC, redR, redC, blueR, blueC, nextRedR, nextRedC, nextBlueR, nextBlueC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static String[][] map;
	static int isSuccess = -1;

	static class Gu {
		int redR, redC, blueR, blueC, nMove;

		public Gu() {}

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
		map = new String[NR][NC];
		for (int r = 0; r < NR; r++) {
			st = br.readLine().split("");
			for (int c = 0; c < NC; c++) {
				if(st[c].equals("R")) {
					map[r][c] = ".";
					redR = r;
					redC = c;
				}else if(st[c].equals("B")) {
					map[r][c] = ".";
					blueR = r;
					blueC = c;
				}
				else map[r][c] = st[c];
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
				if (isSuccess != -1) {
					return;
				}

				// 큐에 추가
				if(nextRedR == currGu.redR && nextRedC == currGu.redC && nextBlueR == currGu.blueR && nextBlueC == currGu.blueC) continue;
				que.add(new Gu(nextRedR, nextRedC, nextBlueR, nextBlueC, currGu.nMove + 1));
			}
		}
	}

	private static boolean move(int dir, Gu curr) {

		boolean redFlag, blueFlag;
		
		redFlag = blueFlag = true;
		while (true) {

			// 움직일 수 있으면 움직이기
			if(redFlag) {
				nextRedR = nextRedR + dr[dir];
				nextRedC = nextRedC + dc[dir];
				if(map[nextRedR][nextRedC].equals("#")) {
					redFlag = false;
					nextRedR = nextRedR-dr[dir];
					nextRedC = nextRedC-dc[dir];
				}
			}
			
			if(blueFlag) {
				nextBlueR = nextBlueR + dr[dir];
				nextBlueC = nextBlueC + dc[dir];
				if(map[nextBlueR][nextBlueC].equals("#")) {
					nextBlueR = nextBlueR-dr[dir];
					nextBlueC = nextBlueC-dc[dir];
					blueFlag = false;
				}
			}
			
			
			// 벽이 아니거나 위치가 같지 않으면 움직이기
			if( blueFlag ) { 
				if(!(nextRedR == nextBlueR && nextRedC == nextBlueC )) {				
					// 파란색이 구멍에 들어가면 이동 못함
					if(map[nextBlueR][nextBlueC].equals("O")) {
						isSuccess = -1;
						return false;
					}
				} else {
					// 못 움직이면 위치 갱신
					nextBlueR = nextBlueR-dr[dir];
					nextBlueC = nextBlueC-dc[dir];
					blueFlag = false;
				}
			}
			
			if(redFlag) {
				if(!(nextRedR == nextBlueR && nextRedC == nextBlueC ))  {				
					// 빨간색이 구멍에 들어가면 빨간색 이동 종료
					if(map[nextRedR][nextRedC].equals("O")) {
						isSuccess = curr.nMove+1;
						nextRedR = 11;
						nextRedC = 11;
						redFlag = false;
					}
				} else {
					// 못 움직이면 맵 갱신
					nextRedR = nextRedR-dr[dir];
					nextRedC = nextRedC-dc[dir];					
					redFlag = false;
				}
			}
			
			// 둘 다 이동을 못하면 종료
			if (!redFlag && !blueFlag) break;

		}
		return true;
	}
}
