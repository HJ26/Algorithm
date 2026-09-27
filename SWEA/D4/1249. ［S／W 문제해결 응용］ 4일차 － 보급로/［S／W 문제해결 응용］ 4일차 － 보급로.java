import java.util.*;
import java.io.*;

class Solution {

	static int N;
	static String[] graph = new String[100];
	static int[][] dp = new int[100][100];	
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    
    static class Node implements Comparable<Node>{
        public int time;
        public int r;
        public int c;
        Node(int time, int r, int c){
            this.time = time;
            this.r = r;
            this.c = c;
        }
        @Override
        public int compareTo(Node node) {
            if(this.time < node.time) {
                return -1;
            }
            else if(this.time > node.time) {
                return 1;
            }
            return 0;
        }
    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
            
			N =Integer.parseInt(br.readLine());
			
			for(int i=0; i<N; i++) {
				graph[i] = br.readLine();
			}
            
			for(int i=0; i<N ;i++) {
				for(int j=0; j<N; j++) {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			dp[0][0] = 0;
			
			dijkstra();
			sb.append("#" + tc + " " + dp[N-1][N-1] + "\n");
		}
        System.out.println(sb);
	}
    
    static private void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue();
		pq.add(new Node(0,0,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
            
			if(cur.time > dp[cur.r][cur.c]) continue;
			
			for(int i=0; i< 4; i++) {
				int nr = cur.r+dir[i][0];
				int nc = cur.c+dir[i][1];
				if(nr <0 || nr >= N || nc < 0 || nc >= N) continue;
                
				int nextTime = cur.time + (int)(graph[nr].charAt(nc)-'0');
				if(dp[nr][nc]>nextTime) {
					dp[nr][nc] = nextTime;
					pq.add(new Node(nextTime,nr,nc));
				}
			}
		}
	}
}
