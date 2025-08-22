import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> ladder = new HashMap<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Map<Integer, Integer> snake = new HashMap<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {1, 0});
        
        boolean[] visit = new boolean[101];
        visit[1] = true;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[0] >= 100) {
                System.out.println(cur[1]);
                break;
            }


            for(int i = 6; i > 0; i--){
                int next = cur[0] + i;
                if(next > 100) {
                    que.add(new int[] { next, cur[1] + 1});
                    break;
                }
                
                if(ladder.containsKey(next)){
                    next = ladder.get(next);
                }
                
                if(snake.containsKey(next)){
                    next = snake.get(next);
                }
                
                if(!visit[next]){
                    visit[next] = true;
                    que.add(new int[] {next, cur[1]+1});
                }
            }

        }
    }

}
