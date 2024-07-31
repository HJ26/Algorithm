import java.io.*;
import java.util.*;

public class Main {

	static int[][] wall;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N;
	
	static String rslt = "NO";
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		wall = new int[N][N];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				String info = st.nextToken();
				wall[r][c] = (info.equals("S") ? 1 : info.equals("T") ? 2 : 0) ; 			
				}
		}

		// 빈공간을 기준으로 벽 새우기 ( 벽 == -1 )
		buildWall(0,0,0);
		
		bw.write(rslt);
		bw.close();
		br.close();
		
	}

	private static void buildWall(int r, int c, int nWall) {
		
		// 벽 3개 되면 학생을 찾을 수 있는지 확인
		if(nWall == 3) {
			if(checkStudent()) rslt = "YES";
			return;
		}
		
		if( r == N ) {
			return;
		} else if( c == N ) {
			buildWall(r+1, 0, nWall);
			return;
		}
		
		// 장애물 짓기
		if(wall[r][c] == 0) {

			wall[r][c] = -1;
			buildWall(r,c+1,nWall+1);
			if(rslt.equals("YES")) return;
			wall[r][c] = 0;
		
		}
		buildWall(r,c+1,nWall);
		if(rslt.equals("YES")) return;
	}

	private static boolean checkStudent() {
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(wall[r][c] == 2) {
					if( findStudent(r,c) ) return false; 
				}
			}
		}
		
		return true;
	}

	private static boolean findStudent(int r, int c) {
		
		for(int dir = 0; dir < 4; dir++) {
			
			int nextR = r;
			int nextC = c;
				
			while( true ) {
				
				nextR = nextR + dr[dir];
				nextC = nextC + dc[dir];
				
				if(nextR >= N || nextR < 0 || nextC >= N || nextC < 0) break;
				if(wall[nextR][nextC] == 1) return true;
				else if(wall[nextR][nextC] == -1) break;
				
			}
		}
		return false;
	}
	
}
