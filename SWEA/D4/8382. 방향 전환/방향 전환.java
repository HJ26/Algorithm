import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
    private static int x1, x2, y1, y2, min;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            min = Integer.MAX_VALUE;
 
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
             
            move(true);
            move(false);
            sb.append("#" + tc + " " + min + "\n");
        }
        System.out.println(sb);
    }
 
    private static void move(boolean flag) {
        int dx = x1, dy = y1, count = 0;
         
        while (true) {
            if (dx == x2 && dy == y2) {
                if (min > count) min = count;
                break;
            }
             
            if (flag) {
                if (dy > y2) dy--;
                else dy++;
                flag = false;
                 
            } else {
                if (dx > x2) dx--;
                else dx++;
                flag = true;
            }
            count++;
        }
    }
}
