import java.io.*;
import java.util.*;

public class Main {
	static int N, M, nSafe = 0, nSafeTmp, minSec;			
	static int[][] map;					// 연구소 정보
	static List<Virus> allVirus;				// 모든 바이러스의 위치 정보
	static int[] virusPlace;					// 활성 바이러스의 위치정보 저장
	static int[] dr = { -1, 1, 0, 0}, dc = { 0, 0, -1, 1 };
	
	static class Virus{
		int r, c, sec = 0;
		public Virus() {}
		public Virus(int r, int c) {
			this.r = r;
			this.c = c;
		}
		public Virus(int r, int c, int sec) {
			this.r = r;
			this.c = c;
			this.sec = sec;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());			// 지도 크기
		M = Integer.parseInt(st.nextToken());			// 활성 바이러스 개수
		map = new int[N][N];							// 지도
		allVirus = new LinkedList<>();					// 모든 바이러스의 위치
		virusPlace = new int[M];						// 활성 바이러스의 위치
		
		// 데이터 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 바이러스면 위치 값 저장
				if(map[i][j] == 2) allVirus.add(new Virus(i,j));
				if(map[i][j] == 0) nSafe++;			// 빈 공간이면 추가
			}
		}
		
		if(nSafe != 0) {
			// 활성바이러스로 바꿀 조합 찾기
			minSec = Integer.MAX_VALUE;
			findCombi(0,0);			
			if(minSec == Integer.MAX_VALUE) minSec = -1;
		}
		else {
			minSec = 0;
		}
		
		// 출력
		System.out.println(minSec);
	}
	
	// 바이러스 위치 조합 찾기
	private static void findCombi(int idx, int sidx) {
		// 조합 찾았으면 바이러스 퍼트리기
		if(sidx == M) {
			doVirus();
			return;
		}
		
		// 모든 바이러스 정보 확인했으면 종료
		if(idx == allVirus.size()) return;
		
		// 조합 뽑기
		virusPlace[sidx] = idx;
		findCombi(idx+1, sidx+1);
		findCombi(idx+1, sidx);
		
	}
	
	// 바이러스 퍼트리기
	private static void doVirus() {
		
		nSafeTmp = nSafe;					// 이번 조합에서의 안전구역 수
		
		Queue<Virus> que = new LinkedList<>();	// 바이러스 위치
		boolean[][] visit = new boolean[N][N];	// 방문 처리
		
		for(int i = 0; i < M; i++) {			// 현재 활성 바이러스의 위치를 큐에 저장
			Virus v = allVirus.get(virusPlace[i]);
			visit[v.r][v.c] = true;
			que.add(new Virus(v.r, v.c));
		}
		
		// 큐가 빌때까지
		while(!que.isEmpty()) {
			Virus v = que.poll();
			
			// 사방탐색
			for(int dir =0 ; dir < 4; dir++) {
				int nextR = v.r + dr[dir];
				int nextC = v.c + dc[dir];
				
				// 다음 위치가 맵 밖이거나, 방문했거나, 벽이면 다음 방향 보기
				if( nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || visit[nextR][nextC] || map[nextR][nextC] == 1 ) continue;
				
				// 아니면 복제
				
				// 복제하려는 곳이 빈공간이면 안전구역 감소
				if(map[nextR][nextC] == 0 ) nSafeTmp--;										// 안전구역 감소
				if(nSafeTmp == 0) {								// 안전구역이 0 이면 최소값 찾기
					minSec = minSec > v.sec + 1 ? v.sec+1 : minSec;
					return;
				}
				
				visit[nextR][nextC] = true;
				que.add(new Virus(nextR, nextC, v.sec+1));	// 바이러스 위치 저장
				
			}
		}
	}
}
