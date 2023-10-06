import java.io.*;
import java.util.*;

public class Main {

	static int NR, NC, nSafe, maxSafe; // 가로 세로 길이
	static int[][] map; // 연구소 정보
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<Point> points;
	static int[] select;

	static class Point {
		int r, c;

		public Point() {
			// TODO Auto-generated constructor stub
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		NR = Integer.parseInt(st.nextToken());
		NC = Integer.parseInt(st.nextToken());
		map = new int[NR][NC];
		points = new ArrayList<Main.Point>();

		nSafe = NR * NC;
		maxSafe = 0;
		// 연구소 초기화
		for (int r = 0; r < NR; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < NC; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] != 0)
					nSafe--;
				else
					points.add(new Point(r, c));
			}
		}

		// 시작

		// 벽세우기
		select = new int[3];
		build(0, 0);
		
		System.out.println(maxSafe);

	}

	private static void build(int idx, int sidx) {

		// 조합 3개 다 찾았으면 안전거리 확인
		if (sidx == 3) {
			maxSafe = Math.max(checkNsafe(), maxSafe);
			return;
		}
        
        // 모든 요소 봤으면 리턴
        if(idx == points.size()) return;

		// 아직 못찾았으면 구하기
		// 내 자리 뽑고 다음 자리 뽑기
		select[sidx] = idx;
		build(idx + 1, sidx + 1);

		// 내 자리 안뽑고 뽑기
		build(idx + 1, sidx);

	}

	private static int checkNsafe() {
		
		int[][] mapTmp = new int[NR][NC];
		int nSafeTmp = nSafe;
		
		// 지도 복사하기
		for(int i =0; i < NR; i++) {
			for(int j = 0; j < NC; j++) {
				mapTmp[i][j] = map[i][j];
			} 
		}
		// 벽으로 바꾸기
		for(int idx : select) {
			mapTmp[points.get(idx).r][points.get(idx).c] = 1;
			nSafeTmp--;
		}
		
		// 탐색
		Queue<Point> que = new LinkedList<Main.Point>();
		for(int i =0; i < NR; i++) {
			for(int j = 0; j < NC; j++) {
				if(mapTmp[i][j] == 2) que.add(new Point(i,j));
			}
		}
		
		while(!que.isEmpty()) {
			
			Point curr = que.poll();
			int currR = curr.r;
			int currC = curr.c;
			for(int dir = 0; dir < 4; dir++) {
				int nextR = currR + dr[dir];
				int nextC = currC + dc[dir];
				if(nextR < 0 || nextR >= NR || nextC < 0 || nextC >= NC || mapTmp[nextR][nextC] != 0) continue;
				mapTmp[nextR][nextC] = 2;
				nSafeTmp--;
				que.add(new Point(nextR, nextC));
			}
		}
		
		return nSafeTmp;
	}

}
