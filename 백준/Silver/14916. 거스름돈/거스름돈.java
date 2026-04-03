import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = -1;
        int N = Integer.parseInt(br.readLine());
        
        for(int i=N/5; i >= 0; i--){
            if((N - (5 * i))%2 == 0){
                answer = i + (N - (5 * i))/2;
                break;
            }
        }
        System.out.println(answer);
    }
}