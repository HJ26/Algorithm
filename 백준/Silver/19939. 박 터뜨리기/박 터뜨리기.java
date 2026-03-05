import java.util.*;
import java.io.*;
public class Main{
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int ball = Integer.parseInt(st.nextToken());
        final int basket = Integer.parseInt(st.nextToken());
        
        for(int i=1;i<basket+1;i++) {
            ball-=i;
            if(ball < 0) {
                break;
            }
        } 
        
        if(ball >=0) {
            if(ball%basket > 0) {
                sb.append(basket);
            }else {
                sb.append(basket-1);
            }
        }else {
            sb.append(-1);
        }
        
        sb.append("\n"); 
        System.out.println(sb.toString());
    }

    
}