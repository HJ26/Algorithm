import java.io.*;
import java.util.*;

public class Main{

    static int N;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		N = Integer.parseInt(br.readLine());
		int[][] gameArea = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				gameArea[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = false;
			}
		}
		BFS(gameArea, visited);
	}
	
	static void BFS(int[][] gameArea, boolean[][] visited) {
		
		boolean result = false;
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {0,0});
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int row = now[0];
			int col = now[1];
			
			visited[row][col] = true;
			
			if(gameArea[row][col] == -1) {
				result = true;
				break;
			}
			
			int bottom = row + gameArea[row][col];
			int right = col + gameArea[row][col];
			
			if(bottom < N && !visited[bottom][col]) {
				que.add(new int[] {row + gameArea[row][col], col});
				visited[bottom][col] = true;
			}
			if(right < N && !visited[row][right]) {
				que.add(new int[] {row, col+gameArea[row][col]});
				visited[row][right] = true;
			}
			
		}
			if(result) {
				System.out.println("HaruHaru");
			}else {
				System.out.println("Hing");
			}
			
		}
	}