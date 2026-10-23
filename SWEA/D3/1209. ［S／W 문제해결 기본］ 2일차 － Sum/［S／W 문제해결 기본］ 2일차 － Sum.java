import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = 100;
        int[][] arr = new int[N][N];

        for (int tc = 0; tc < 10; tc++) {
            int num = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxSum = 0;
            int sumDia1 = 0;
            int sumDia2 = 0;

            for (int i = 0; i < N; i++) {
                int sumRow = 0;
                int sumCol = 0;

                for (int j = 0; j < N; j++) {
                    sumRow += arr[i][j];
                    sumCol += arr[j][i];
                }


                maxSum = Math.max(maxSum, Math.max(sumRow, sumCol));
                
                sumDia1 += arr[i][i];
                sumDia2 += arr[i][N - 1 - i];
            }


            maxSum = Math.max(maxSum, Math.max(sumDia1, sumDia2));


            sb.append("#"+num+" "+maxSum+"\n");
        }

        System.out.println(sb);
    }
}
