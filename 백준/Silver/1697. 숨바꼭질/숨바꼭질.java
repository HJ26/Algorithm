import java.io.*;
import java.util.*;

// 이동할 위치를 저장할 클래스
class Place{
	
	int x;		// 현재 위치
	int time;	// 소요 시간
	
	public Place() {}
	
	public Place(int x, int time) {
		this.x = x;
		this.time = time;
	}

}

public class Main {

	static int N, K; // N :  수빈이 위치 , K : 동생위치
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bw.write(Integer.toString(bfs()));
		bw.close();
		br.close();
		
	}

	private static int bfs() {
		
		// 이동할 경로를 저장할 queue
		Queue<Place> que = new LinkedList<Place>();
		que.add(new Place(N,0));
		
		// 방문 여부를 저장할 배열
		boolean[] visit = new boolean[200001];

		while(!que.isEmpty()) {
			
			// 현재 위치
			Place cur = que.poll();
			int curX = cur.x;
			int curTime = cur.time;
			
			// 현재 위치가 동생위치이면 종료
			if(curX == K) return cur.time;
			
			// 다음 지점 및 시간
			int nextX;
			int nextTime = curTime + 1;
			
			// 다음으로 이동
			for(int i = 0; i < 3; i++) {
				
				// 한칸 앞으로, 한칸 뒤로, 순간이동 시 다음 위치
				if( i == 0 ) nextX = curX + 1;
				else if( i == 1 ) nextX = curX - 1;
				else nextX = curX * 2;
				
				// 배열을 넘어가면 넘어가기
				if( nextX < 0 || nextX > 200000 ) continue;
				
				// 다음 위치가 방문하지 않은 곳일때만 이동
				if( !visit[nextX] ) {
					
					// 큐에 저장
					que.add(new Place(nextX, nextTime));
					// 방문 처리
					visit[nextX] = true;
				}
			}
			
		}
		return -1;
		
		
	}
	
}
