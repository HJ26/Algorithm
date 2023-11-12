import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,K,TIME,goalX,goalY;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0}, dy = { 0, 0, -1, 1};
	
	// 바이러스 위치를 시간 -> 바이러스 순서대로 정렬하기 위한 우선순위 큐
	static PriorityQueue<Virus> pq = new PriorityQueue<Main.Virus>();
	// 바이러스 정보가 담겨있는 클래스
	static class Virus implements Comparable<Virus>{
		int x,y,num,time;
		public Virus() {}
		public Virus(int x, int y, int num,int time) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.time = time;
		}
		@Override
		public int compareTo(Virus o) {
			
			// 시간이 같으면 바이러스 숫자가 낮은걸 먼저
			if(this.time == o.time) {
				return this.num - o.num;
			}
			// 시간별이 빠른 순서대로 정렬
			return this.time - o.time;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 지도 크기
		K = Integer.parseInt(st.nextToken());	// 바이러스 숫자
		map = new int[N][N];					// 지도 정보
		for(int i = 0; i < N; i++) {			// 입력받기
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 바이러스 정보가 들어오면
				// 우선순위 큐에 넣기
				if(map[i][j] != 0) {
					pq.add(new Virus(i,j,map[i][j],0));
				}
				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		TIME = Integer.parseInt(st.nextToken());		// 목표시간
		goalX = Integer.parseInt(st.nextToken())-1;		// 목표 위치
		goalY = Integer.parseInt(st.nextToken())-1;		
		
		// 너비우선탐색 시작
		BFS();

		bw.close();
		br.close();
	}
	private static void BFS() throws IOException {
		
		// 큐가 빌때까지 반복
		while(!pq.isEmpty()) {
			Virus cur = pq.poll();
			// 목표한 시간이 지났으면 위치 정보 출력값에 저장
			if(cur.time == TIME) {
				bw.write(Integer.toString(map[goalX][goalY]));
				return;
			}
			// 시간이 아직 안지났으면 사방탐색
			for(int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];	// 다음위치
				int ny = cur.y + dy[dir];
				// 다음위치가 지도 밖이거나 이미 퍼진 바이러스가 있으면 다음 방향 보기
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0) continue;
				
				// 아직 시간이 안지났는데 목표지점에 바이러스가 퍼졌으면
				// 출력에 저장하고 함수 종료
				if(cur.time < TIME && nx == goalX && ny == goalY) {
					bw.write(Integer.toString(cur.num));
					return;					
				}
				
				// 현재 번호 다음 위치에 퍼트리기
				map[nx][ny] = cur.num;
				
				// 퍼진 위치에 대한 바이러스 저장
				pq.add(new Virus(nx, ny, cur.num, cur.time + 1));
			}
		}
		// 더이상 못퍼지면 목쵸지점 값 출력에 저장
		bw.write(Integer.toString(map[goalX][goalY]));
		
	}
}
