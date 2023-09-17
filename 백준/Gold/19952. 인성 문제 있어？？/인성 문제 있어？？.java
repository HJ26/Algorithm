import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.cert.PolicyQualifierInfo;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 블록의 위치를 저장할 클래스
class Block{
	int x;		// x 좌표
	int y;		// y 좌표
	int height;	// 해당하는 칸의 높이
	int energy;	// 현재 칸에서의 에너지
	Block(int x, int y, int height, int energy){
		this.x = x;
		this.y = y;
		this.height = height;
		this.energy = energy;
	}
}
public class Main {

	public static int W, H, energy, startX, startY, endX, endY;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int[][] maze;
	public static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int nBlock = Integer.parseInt(st.nextToken());
			energy = Integer.parseInt(st.nextToken());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			// 데이터 받기
			maze = new int[W+1][H+1];
			visit = new boolean[W+1][H+1];
			for(int i = 0; i < nBlock; i++) {
				st = new StringTokenizer(br.readLine());
				maze[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken()); 
			}

			// 탐색 시작
			if(!BFS()) {	// 목표지점까지 갈 수 없을때
				System.out.println("인성 문제있어??");
			}else {			// 목표지점까지 갈 수 있을때
				System.out.println("잘했어!!");
			}
		}	
	}

	private static boolean BFS() {
		
		// 시작 지점과 종료 지점이 동일하면 true 리턴
		if(startX == endX && startY == endY ) return true;
		// 탐색할 칸을 넣어줄 큐 생성
		Queue<Block> que = new LinkedList<>();
		
		// 시작점의 위치를 큐에 저장 및 방문처리
		que.add(new Block(startX, startY, maze[startX][startY], energy));
		visit[startX][startY] = true;
		
		// 큐가 빌 때까지 ( 더이상 갈 수 있는 칸이 없을때까지 ) 반복
		while(!que.isEmpty()) {
			
			// 큐의 가장 처음값을 가져온 후 해당하는 블록의 정보를 변수로 저장
			Block currInfo = que.poll();
			int currX = currInfo.x;
			int currY = currInfo.y;
			int currHe = currInfo.height;
			int currEn = currInfo.energy;
            
            // 현재 내 힘이 1 보다 작으면 다음 가능한 값 탐색
			if(currEn < 1) continue;
			
			// 상 하 좌 우 방향 탐색
			for(int i = 0; i < 4; i++) {
				
				// 내가 탐색할 위치의 정보 저장
				int nextX = currX + dx[i];
				int nextY = currY + dy[i];
				
				// 범위 밖에 있거나 방문한 적이 있으면 다음 방향 탐색
				if( nextX <= 0 || nextX > W || nextY <= 0 || nextY > H) continue;
				if( visit[nextX][nextY] ) continue;
				
				// 내가 탐색할 칸이 내가 갈 수 있는 칸이면 큐에 저장하고 방문 처리
				int nextHe = maze[nextX][nextY];
				
				// 현재 내 에너지가 뛰어야 할 높이보다 낮으면 다음 방향 탐색
				if( currEn < (nextHe-currHe) ) continue;
				
				// 다음 칸 탐색 가능
				// 탐색하려는 위치가 목표지점이면 탐색 가능하다고 return
				if(nextX == endX && nextY == endY) return true;
				
				// 목표지점이 아니면 큐에 추가하고 방문처리
				que.add(new Block(nextX, nextY, nextHe, currEn-1));
				visit[nextX][nextY] = true;
				
			}
		}
		// 탐색이 가능하지 않은채로 큐가 모두 비면 false 리턴
		return false;
	}
}
