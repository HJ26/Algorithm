import java.util.*;
import java.io.*;

class Solution {
    static int[][] map;
    static int[] dx = { 1, -1, 0, 0, }, dy = { 0, 0, 1, -1 };
	static HashSet<String> hs;
    
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
            hs = new HashSet<>();
            StringTokenizer st;
            
            map = new int[4][4];
            for(int i=0; i<4; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<4; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    move(i, j, 0, ""+map[i][j]);
                }
            }
            System.out.println("#" + tc + " " + hs.size());
		}
	}
    
    static void move(int x, int y, int depth, String str) {
		
		if(depth == 6) {
			hs.add(str);
			return;
		}
		for(int t=0; t<4; t++) {
			int nx = x + dx[t];
			int ny = y + dy[t];
			
			if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4) { 
				move(nx, ny, depth + 1, str+map[nx][ny]); 
			}
		}
		
	}
}