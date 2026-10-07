import java.io.*;

public class Solution {
    static char[] arr;
    static int min, max;

    static void change(int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        if (arr[0] != '0') {
            int M = 0;
            for (int k = 0; k < arr.length; k++) {
                M *= 10;
                M += arr[k] - '0';
            }

            min = Math.min(min, M);
            max = Math.max(max, M);
        }

        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            min = N;
            max = N;

            arr = Integer.toString(N).toCharArray();

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    change(i, j);
                }
            }

            sb.append("#"+tc+" "+min+" "+max+"\n");
        }

        System.out.println(sb);
    }
}