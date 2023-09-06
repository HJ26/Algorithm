import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer NL =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(NL.nextToken());
        int L = Integer.parseInt(NL.nextToken());
        
        StringBuilder sb = new StringBuilder();
        Deque<int[]> deque = new ArrayDeque<int[]>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            int[] num = new int[] { Integer.parseInt(input[i]), i };
            if( !deque.isEmpty()) {
            	if( deque.peek()[1] < i - L + 1) deque.poll();
            	while( !deque.isEmpty() && deque.peekLast()[0] > num[0]) deque.pollLast();            	
            }
            deque.add(num);
            sb.append(deque.peek()[0]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
