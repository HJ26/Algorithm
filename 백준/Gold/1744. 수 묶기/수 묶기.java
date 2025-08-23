import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp > 0) plus.add(tmp);
            else minus.add(tmp);
        }

        int answer = 0;
        while(!plus.isEmpty()){
            int pNum = plus.poll();
            if(!plus.isEmpty() && plus.peek() != 1) pNum *= plus.poll();
            answer += pNum;
        }

        while(!minus.isEmpty()){
            int mNum = minus.poll();
            if(!minus.isEmpty()) mNum *= minus.poll();
            answer += mNum;
        }

        System.out.println(answer);
    }
}
