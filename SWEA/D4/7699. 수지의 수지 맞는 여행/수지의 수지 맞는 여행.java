import java.io.*;
import java.util.*;

public class Solution {
    static char[][] array;
    static int R, C;
    static int max;
    static int[] dx = {-1, 0, 1, 0}, dy = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(bf.readLine());

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            array = new char[R][C];
            Set<Character> visited = new HashSet<Character>();
            max = Integer.MIN_VALUE;
            for (int i = 0; i < R; i++) {
                String line = bf.readLine();
                for (int j = 0; j < C; j++) {
                    array[i][j] = line.charAt(j);
                }
            }

            find(0, 0, visited);

            System.out.println("#" + tc + " " + max);

        }
    }
    
    static void find(int nx, int ny, Set<Character> visited) {
        
        char curc = array[nx][ny];

        if (!visited.contains(curc)) {
            visited.add(curc);
            if (visited.size() > max) {
                max = visited.size();
            }
            for (int i = 0; i < 4; i++) {
                if (nx + dx[i] >= 0 && nx + dx[i] < R && ny + dy[i] >= 0 && ny + dy[i] < C) {
                    find(nx + dx[i], ny + dy[i], visited);
                }
            }
            visited.remove(curc);
        }
    }
}