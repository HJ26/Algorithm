import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        outer: for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            char[][] board = new char[n][m];
            Deque<int[]> queue = new ArrayDeque<>();
            for(int i=0; i<n; i++) {
                String line = br.readLine();
                board[i] = line.toCharArray();
                for(int j=0; j<m; j++) {
                    if(board[i][j] != '?') {
                        queue.add(new int[] {i, j});
                    }
                }
            }
            
            while(!queue.isEmpty()) {
                int[] current = queue.remove();
                char next = board[current[0]][current[1]] == '.' ? '#' : '.';
                for(int i=0; i<4; i++) {
                    int nr = current[0] + dr[i], nc = current[1] + dc[i];
                    if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if(board[nr][nc] == board[current[0]][current[1]]) {
                        sb.append("impossible").append('\n');
                        continue outer;
                    }
                    if(board[nr][nc] != '?') continue;
                    board[nr][nc] = next;
                    queue.add(new int[] {nr, nc});
                }
            }
            sb.append("possible").append('\n');
            
        }
        
        System.out.print(sb);
    }
}

