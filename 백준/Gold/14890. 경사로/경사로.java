import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로 탐색
        L1:
        for(int r = 0; r < N; r++){
            int seq = 0;
            int last = map[r][0];
            int tmp = 0;
            for(int c = 0; c < N; c++){
                
                // 높이 차이가 2인 경우
                if( Math.abs(last - map[r][c]) > 1 ) continue L1;
                
                // 높이가 동일한경우
                if(last == map[r][c]){
                    if(tmp > 0) tmp--;
                    else seq++;
                    last = map[r][c];
                    continue;
                }
                // 높이가 높아지는 경우
                else if(last < map[r][c]){
                    if(tmp > 0 || seq < L) continue L1;
                }
                // 높이가 낮아지는 경우
                else if(last > map[r][c]){
                    if(tmp > 0) continue L1;
                    tmp = L-1;
                    seq = 0;
                    last = map[r][c];
                    continue;
                }

                seq = 1;
                last = map[r][c];
            }
            if(tmp == 0) {
                answer++;
            }
        }

        // 세로 탑색
        L1:
        for(int c = 0; c < N; c++){
            int seq = 0;
            int last = map[0][c];
            int tmp = 0;
            for(int r = 0; r < N; r++){

                // 높이 차이가 2인 경우
                if( Math.abs(last - map[r][c]) > 1 ) continue L1;
                
                // 높이가 동일한경우
                if(last == map[r][c]){
                    if(tmp > 0) tmp--;
                    else seq++;
                    last = map[r][c];
                    continue;
                }
                // 높이가 높아지는 경우
                else if(last < map[r][c]){
                    if(tmp > 0 || seq < L) continue L1;
                }
                // 높이가 낮아지는 경우
                else if(last > map[r][c]){
                    if(tmp > 0) continue L1;
                    tmp = L-1;
                    seq = 0;
                    last = map[r][c];
                    continue;
                }

                seq = 1;
                last = map[r][c];
            }
            if(tmp == 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}
