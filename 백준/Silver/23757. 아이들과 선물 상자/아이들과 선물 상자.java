import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 1;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        st = new StringTokenizer(br.readLine());
        
        // 선물 개수 큐에 저장하기
        for (int i = 0; i < N; i++) pq.add(Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int cur = Integer.parseInt(st.nextToken());    // 원하는 선물 개수
            int max = pq.poll();                           // 현재 가장 많은 선물 개수
            
            // 원하는 개수가 최대 개수보다 많으면
            // 가져가지 못하는 아이가 있으므로 0 으로 변경
            if (cur > max) {
                ans = 0;
                break;
            }
            
            // 남은 선물개수 다시 큐에 저장
            pq.add(max-cur);
        }
        
        // 출력
        System.out.println(ans);
    }
}