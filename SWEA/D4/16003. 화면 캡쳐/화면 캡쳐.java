import java.io.*;

public class Solution {
    static int N, size;
    static int[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            size = Math.min(N, 50);
            order = new int[size];

            int count = 0;
            for (int i = 1; i <= 9; i++) {
                order[count++] = i;
                count = makeOrder(count, i);

                if (count == Math.min(50, N)) {
                    break;
                }
            }

            sb.append("#"+tc+" ");

            for (int i = 0; i < size; i++) {
                sb.append(order[i]+".png"+" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
    
    private static int makeOrder(int count, int number) {
        number *= 10;

        for (int i = 0; i <= 9; i++) {
            if (count == size || number + i > N) {
                break;
            }

            if (N / ((number + i) * 10) > 0) {
                order[count++] = number + i;
                count = makeOrder(count, number + i);
            } else {
                order[count++] = number + i;
            }
        }

        return count;
    }
}