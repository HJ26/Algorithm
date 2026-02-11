import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N >= 100){
            if(N == 1000) N = 999;
            
            int cnt = 99;
            for(int i =100; i<= N; i++){
                int hundred = i/100;
                int ten = (i/10)%10;
                int one = i%10;
            
                if(hundred - ten == ten - one) cnt++;
            }
            
            System.out.println(cnt);

        }else System.out.println(N);
    }
}