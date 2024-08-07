import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));

        charge(list,0);
        System.out.print(max);
        
    }
    static void charge(List<Integer> list, int sum) {
        
        if (list.size() == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int tmp = list.get(i);
            int chargeValue = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            charge(list, sum + chargeValue);
            list.add(i, tmp);
        }
    }
}