import java.io.*;
import java.util.*;

public class Solution {
    static long[] players;
    static long[] foods;
    static int N;
    static long k;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            k = Long.parseLong(st.nextToken());
            
            players = new long[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) players[i] = Long.parseLong(st.nextToken());
            Arrays.sort(players);
            
            foods = new long[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) foods[i] = Long.parseLong(st.nextToken());
            Arrays.sort(foods);
            
            long answer = binarySearch(0, players[N-1] * foods[N-1]);
            sb.append(answer).append('\n');
        }
        
        System.out.print(sb);
    }
    
    private static long binarySearch(long l, long r) {
        long start = l, end = r;
        while(end > start) {
            long mid = (start + end) / 2;
            long score = 0;
            for(int i=0; i<N; i++) {
                if(mid >= players[i] * foods[N -1 -i]) continue;
                score += players[i] - (mid / foods[N -1 -i]);
                if(score > k) {
                    start = mid + 1;
                    break;
                }
            }
            if(k >= score) {
                end = mid;
            }
        }
        return end;
    }
}