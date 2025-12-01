import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] answer = new int[N];
        PriorityQueue<Integer>[] orderCustomer = new PriorityQueue[200001];
        for(int i = 0; i < 200001; i++) orderCustomer[i] = new PriorityQueue<>();

        // 각 주문초밥에 대해 주문한 사람 정보 넣기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            for(int t = 0; t < T; t++){
                orderCustomer[Integer.parseInt(st.nextToken())].add(i);
            }
        }

        // 주문 받기
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int idx = Integer.parseInt(st.nextToken());
            if(!orderCustomer[idx].isEmpty()) answer[orderCustomer[idx].poll()]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());

    }
}