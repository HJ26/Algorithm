import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N-1; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }


        int answer = 0;
        while(!pq.isEmpty() && dasom <= pq.peek()){
            int max = pq.poll();
            pq.add(--max);
            dasom++;
            answer++;
        }

        System.out.println(answer);
    }

}
