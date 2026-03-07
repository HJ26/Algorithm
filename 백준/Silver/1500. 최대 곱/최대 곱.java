import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
 
        if(s==k){
            System.out.println("1");
            return;
        }
        
        int max = 0;
        List<Integer> list = new ArrayList<>();
        
        while (true){
            if(s <= 0){
                break;
            }
            int a = s / k;
            list.add(a);
            s = s - a;
            k--;
 
        }
 
        long sum = 1;
        for (int i = 0; i < list.size(); i++) {
            sum *= list.get(i);
 
        }
        System.out.println(sum);
    }
}