import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
 
        int[] listQueuestack = new int[N];
        int[] currentList = new int[N];
 
        StringBuilder answer = new StringBuilder();
        
        // 1번 리스트 - 자료구조의 형태
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            listQueuestack[i] = Integer.parseInt(st.nextToken());
        }
        
        // 2번 리스트 - 자료구조의 요소
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            currentList[i] = Integer.parseInt(st.nextToken());
        }
 
        int M = Integer.parseInt(br.readLine());
        int[] insertList = new int[M];
        // 3번 리스트 - 입력값 리스트
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            insertList[i] = Integer.parseInt(st.nextToken());
        }
        
        // 큐 생성
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (listQueuestack[i] == 0) {
                que.addFirst(currentList[i]);
            }
        }
        
        for (int i = 0; i < M; i++) {
            que.add(insertList[i]);
            answer.append((que.pollFirst() + " "));
        }
 
        System.out.println(answer);
    }
}