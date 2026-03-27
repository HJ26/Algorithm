import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int cnt = 0;
        
        for (int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            int personX = Integer.parseInt(st.nextToken()); //선수x좌표
            int personY = Integer.parseInt(st.nextToken()); //선수y좌표
            if (personX >= X && personX <= W + X && personY >= Y && personY <= H + Y){ //범위1
                cnt++;
            } else if (personX < X) {
                if (
                        (int)Math.pow(personX - X, 2) + (int)Math.pow(personY -Y - (H / 2), 2) <= (int)Math.pow(H / 2, 2) //범위2
                ){
                    cnt++;
                }
            } else if (personX > X + W) {
                if (
                        (int)Math.pow(personX - W - X, 2) + (int)Math.pow(personY - Y - (H / 2), 2) <= (int)Math.pow(H / 2, 2) //범위3
                ){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}