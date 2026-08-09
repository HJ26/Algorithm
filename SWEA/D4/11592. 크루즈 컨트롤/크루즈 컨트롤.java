import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');
            StringTokenizer st = new StringTokenizer(br.readLine());
            double d = Double.parseDouble(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            Horse[] board = new Horse[n];
            double min = d * 60 * 60;
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
                board[i] = new Horse(k, s);
            }
            Arrays.sort(board);
            if(n == 1) min = Math.min(min, (d-board[0].start)/board[0].speed);
            else {
                if(board[1].speed > board[0].speed) {
                    double sameTime = (double)(board[0].start - board[1].start) / (board[1].speed - board[0].speed);
                    if(sameTime * board[1].speed + board[1].start < d) min = Math.min(min, (d-board[0].start)/board[0].speed); 
                    else min = Math.min(min, (d-board[1].start)/board[1].speed);
                } else min = Math.min(min, (d-board[1].start)/board[1].speed);
            }
            
            sb.append(d/min).append('\n');
        }
        
        br.close();
        System.out.print(sb);
    }
    
    static class Horse implements Comparable<Horse> {
        int start, speed;
        
        public Horse(int start, int speed) {
            this.start = start;
            this.speed = speed;
        }

        @Override
        public int compareTo(Horse o) {
            return o.start - this.start;
        }
    }
}