import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] currentParking = new int[n + 1];
        int[] carWeight = new int[m + 1];
        int[] parkingWeight = new int[n + 1];
        int sum = 0;

        for (int i = 1; i <=n; i++) parkingWeight[i] = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <=m; i++) carWeight[i] = Integer.parseInt(br.readLine());
        
        Queue<Integer> que = new LinkedList<>();

        L1: for (int i = 0; i < 2 * m; i++) {
            int car = Integer.parseInt(br.readLine());

            if (car > 0){
                for (int j = 1; j < n + 1; j++) {
                    if (currentParking[j] == 0) {
                        currentParking[j] = car;
                        continue L1;
                    }
                }
                que.offer(car);
            } else {
                for (int j = 1; j < n + 1; j++) {
                    if (currentParking[j] == car * (-1)) {
                        currentParking[j] = 0;
                        sum += parkingWeight[j] * carWeight[car * (-1)];
                        if (!que.isEmpty()) currentParking[j] = que.poll();
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}