import java.io.*;
import java.util.*;

public class Main {
    static int N,M,minCnt,startR,startC;
    static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1};
    static char[][] maze;								// 미로 정보
    static Queue<Place> que = new LinkedList<>();		// 경로를 저장할 큐
    
    // 위치 정보를 저장할 클래스
    static class Place{
        int x,y, cnt,keys;

        public Place(int x, int y, int cnt, int keys) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.keys = keys;
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // N M 입력받기
        st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // maze 입력받기
        maze = new char[N][M];
        
        for(int r = 0; r < N; r++) {
            String input = br.readLine();
            for(int c = 0; c < M; c++) {
                maze[r][c] = input.charAt(c);
                // 도착지 위치 정보 저장
                if(maze[r][c]=='0') {
                    que.add(new Place(r,c,0,0));
                }
            }
        }
        
        // 이동하기
        minCnt = -1;
        move();
        
        // 출력하기
        bw.write(Integer.toString(minCnt));
        bw.close();
        br.close();
    }

    private static void move() {
        
        // 방문처리할 배열
    	// 내가 가지고 있는 키 조합(2^8)만큼 개별로 방문처리를 해줘야 함
        boolean[][][] visit = new boolean[N][M][64];
        
        while(!que.isEmpty()) {
        	
        	// 현재 위치 정보
            Place cur = que.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curCnt = cur.cnt;
            int curKeys = cur.keys;
            
            // 도착지 만나면 종료
            if(maze[curX][curY] == '1') {
            	minCnt = cur.cnt;
            	return;
            }
            
            // 사방 탐색
            for(int dir = 0; dir < 4; dir++) {
            	
            	// 다음 갈 곳 좌표
            	int nextX = curX + dx[dir];
            	int nextY = curY + dy[dir];
            	
            	// 미로 밖으로 벗어나거나 방문한 적 있으면 다음 방향 탐색
            	if(nextX < 0 || nextX >= N || nextY <0 || nextY >= M || visit[nextX][nextY][curKeys]) continue;
            	
            	// 방문한 적 없으면 내가 갈 수 있는 곳인지 판단
            	
            	// 1. 다음 방향이 그냥 갈 수 있는 곳일때
            	if( maze[nextX][nextY] == '.' || maze[nextX][nextY] == '0' || maze[nextX][nextY] == '1') {
            		visit[nextX][nextY][curKeys] = true; 						// 방문처리하고					// 방문 표시하고
            		que.add(new Place(nextX, nextY, curCnt+1, curKeys));		// 큐에 저장
            	}
            	// 2. 다음 방향에 열쇠가 있을 때
            	else if( maze[nextX][nextY] >= 'a' && maze[nextX][nextY] <= 'z') {
            		int mazeKey = 1 << (maze[nextX][nextY] - 'a');			// 지도의 키를 숫자로 바꿔주기
            		int nextKeys = curKeys | mazeKey;						// 내가 얻은 키 정보 업데이트
            		visit[nextX][nextY][nextKeys] = true;					// 방문처리
            		que.add(new Place(nextX, nextY, curCnt+1, nextKeys));	// 큐에 저장
            	}
            	// 3. 다음 방향이 잠금일때
            	else if(  maze[nextX][nextY] >= 'A' && maze[nextX][nextY] <= 'Z' ) {
            		int mazeDoor = 1 << ( maze[nextX][nextY] - 'A');		// 문 정보 숫자로 바꿔주기
            		
            		// 키를 가지고 있으면
            		if( (mazeDoor & curKeys) > 0 ) {							// 키가 아무것도 없으면 겹치는 1이 없으므로 0이 됨
            			visit[nextX][nextY][curKeys] = true;					// 방문처리
            			que.add(new Place(nextX, nextY, curCnt+1, curKeys));	// 큐에 저장
            		}
            		
            	}
            }
            
        }
    }
}