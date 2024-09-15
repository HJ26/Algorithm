import java.io.*;
import java.util.*;

public class Main {
    
    static int N,H,T;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        String answer = "NO";
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 우선순위 큐에 값 넣기
        for (int i = 0; i < N; i++) pq.add(Integer.parseInt(br.readLine()));
        
        // 뿅망치 때리기
        int cnt = 0;
        for (int i = 0; i < T; i++) {
            
            // 가장 큰 키가 거인보다 작거나 1이 되면 종료
            if ((pq.peek() < H) || (pq.peek() == 1)) break;
            cnt++;                    // 횟수 차감
            pq.add(pq.poll() / 2);    // 키 반 줄이기
            
        }
        
        // 다 종료 후 모두가 거인의 키보다 작으면 YES 출력
        if (pq.peek() < H) answer = "YES";
        
        // No인 경우 가장 큰 키 출력하므로 값 바꿔주기
        if(!answer.equals("YES")) cnt = pq.poll(); 
        
        // 출력
        sb.append(answer);
        sb.append("\n");
        sb.append(cnt);        
        System.out.println(sb.toString());
    }
}