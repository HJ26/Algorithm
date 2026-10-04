import java.io.*;
import java.util.*;
 
public class Solution {
    static long N,K,answer,total;
    static PriorityQueue<Long> Lqueue;
    static PriorityQueue<Long> Hqueue;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        for (int tc = 1; tc <= T ; tc++) {
            Lqueue = new PriorityQueue<>(Collections.reverseOrder());
            Hqueue = new PriorityQueue<>();
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
 
            answer = 0;
            total = 0;
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                long num = Long.parseLong(st.nextToken());
                total += num;
                if(num <= K) {
                    Lqueue.add(num);
                }else {
                    Hqueue.add(num);
                }
            }
 
            sb.append("#"+tc+" ");
            for (int n = 0; n < N; n++) {
                if(K >= total) {
                    sb.append(answer+"\n");
                    break;
                }
 
                while (true) {
                    if(!Hqueue.isEmpty() && Hqueue.peek() <= K) {
                        Lqueue.add(Hqueue.poll());
                    }else {
                        break;
                    }
                }
 
                if(Lqueue.isEmpty()) {
                    sb.append(-1+"\n");
                    break;
                }
                long num = Lqueue.poll();
                answer++;
                K += num;
                total -= num;
            }
        }
 
        System.out.println(sb);
 
    }
}