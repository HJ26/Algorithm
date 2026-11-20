import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] numbers = new int[n];
            for(int i=0; i<n; i++) numbers[i] = Integer.parseInt(st.nextToken());
            List<Double> list = new ArrayList<>();
            backtracking(list, numbers, 0, 0, 0);
            double sum = 0;
            for(double average: list) sum += average;
            sb.append("#"+tc+" ").append(sum / list.size()).append("\n");
        }
        System.out.print(sb);
    }
    
    private static void backtracking(List<Double> list, int[] numbers, int sum, int count, int start) {
        if(count != 0) {
            list.add((double)sum /count);
        }
        for(int i=start; i<numbers.length; i++) {
            backtracking(list, numbers, sum+numbers[i], count+1, i+1);
        }
    }
}