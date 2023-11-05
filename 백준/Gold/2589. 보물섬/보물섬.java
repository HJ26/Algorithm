import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int R, C;
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0}, dy = {0,0,-1,1};
	static class Node{
		int x, y, time;
		public Node() {}
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		map = new char[R][C];
		
		// 지도 정보받기
		for(int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		// 최장거리 찾기
		int maxDist = 0;
		
		// 모든 점 탐색
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				// 바다면 다음 점 보기
				if(map[i][j] == 'W') continue;
				// 육지면 최장길이 탐색
				int dist = BFS(i,j);
				maxDist = Math.max(maxDist, dist);
			}
		}
		
		// 출력
		bw.write(Integer.toString(maxDist));
		bw.close();
		br.close();
	}
	private static int BFS(int startX, int startY) {
		// 위치정보 저장할 큐 만들고
		Queue<Node> que = new LinkedList<>();
		
		// 방문처리할 배열 만들고
		boolean[][] visit = new boolean[R][C];
		
		// 시작위치 큐에 넣고 방문 했다고 표시
		que.add(new Node(startX, startY, 0));
		visit[startX][startY] = true;
		
		// 현재 점에서 최장길이를 저장할 변수
		int dist = 0;
		// 큐가 빌때까지 반복
		while(!que.isEmpty()) {
			Node cur = que.poll();
			// 사방탐색
			for(int dir = 0; dir < 4; dir++) {
				int nextX = cur.x + dx[dir];
				int nextY = cur.y + dy[dir];
				
				// 다음위치가 지도 밖이거나, 바다거나, 방문한적 있으면 다음 방향
				if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C || map[nextX][nextY] == 'W' ||visit[nextX][nextY]) continue;
				
				// 없으면 방문했다고 하고 큐에 위치 저장 후 최장길이 업데이트
				visit[nextX][nextY] = true;
				que.add(new Node(nextX, nextY, cur.time+1));
				dist = Math.max(dist, cur.time+1);
			}
		}
		
		// 끝나면 지금까지 구한 최장길이 리턴
		return dist;
	}
}
