import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int cnt = 0, minTime = Integer.MAX_VALUE;	// 가짓수와 최소시간을 저장할 변수
	static class Place{									// 위치를 저장할 클래스
		int x, time;
		public Place() {}
		public Place(int x, int time) {
			this.x = x; 
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int subin = Integer.parseInt(st.nextToken());		// 수빈이 위치
		int sister = Integer.parseInt(st.nextToken());		// 동생 위치
		startGame(subin, sister);							// 게임시작
		
		bw.write(Integer.toString(minTime));				// 출력
		bw.write("\n");
		bw.write(Integer.toString(cnt));
		bw.close();
		br.close();
	}
	private static void startGame(int subin, int sister) throws IOException {
		Queue<Place> que = new LinkedList();		// 너비 탐색을 위한 큐
		boolean[] visit = new boolean[100001];		// 방문처리를 위한 배열 ( 100000 까지 갈 수 있으므로 100001 크기 배열 생성 )

		que.add(new Place(subin, 0));				// 시작위치 큐에 넣기	
		
		// 큐가 빌때까지
		while(!que.isEmpty()) {
			Place cur = que.poll();					// 현재점
			visit[cur.x] = true;					// 방문처리
			if(cur.time > minTime) return;			// 시간이 최소시간보다 커지면 종료
			if(cur.x == sister) {					// 현재 위치와 동생위치가 같으면
				minTime = cur.time;					// 최소시간 저장하고
				cnt++;								// 가짓수 추가
			}
			else if( cur.x > sister) {				// 현재위치가 동생보다 크면
				if((cur.x-1) >= 0 && !visit[cur.x-1]) {	// 뒤로만 가고
					que.add(new Place(cur.x - 1, cur.time+1));
				}
			}
			else {									// 현재위치가 동생보다 작으면
													// x+1, x-1, x*2 이동
				if((cur.x+1) < 100001 && !visit[cur.x+1]) {		
					que.add(new Place(cur.x + 1, cur.time+1));
				}
				if((cur.x*2) < 100001 && !visit[cur.x*2]) {
					que.add(new Place(cur.x * 2, cur.time+1));
				}
				if((cur.x-1) >= 0 && !visit[cur.x-1]) {
					que.add(new Place(cur.x - 1, cur.time+1));
				}
			}
		}
		
	}
}
