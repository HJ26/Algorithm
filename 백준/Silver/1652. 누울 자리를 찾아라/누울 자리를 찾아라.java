import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
		
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
		
        int x_cnt = 0;
        int y_cnt = 0;
        int x_tmp = 0;
        int y_tmp = 0;
		
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == '.') {
                    x_tmp++;
					
                    if (x_tmp == 2) x_cnt++;
                } else {
                    x_tmp = 0;
                }
            }
            x_tmp = 0;
        }
		
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[j][i] == '.') {
                    y_tmp++;
					
                if (y_tmp == 2) y_cnt++;
                
                } else {
                    y_tmp = 0;
                }
            }
			
            y_tmp = 0;
        }
		
        System.out.println(x_cnt + " " + y_cnt);
    }
}