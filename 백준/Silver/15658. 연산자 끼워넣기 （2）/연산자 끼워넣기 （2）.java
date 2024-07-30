import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] numArr;
    static int[] operArr = new int[4];
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        numArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operArr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numArr[0]);
        
        bw.write(Long.toString(max));
        bw.write("\n");
        bw.write(Long.toString(min));
        bw.close();
        br.close();
    }

    public static void dfs(int cnt, long res) {
        if (cnt == n) {
            max = Math.max(res, max);
            min = Math.min(res, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operArr[i] > 0) {
                operArr[i] -= 1;
                switch (i) {
                    case 0:
                        dfs(cnt + 1, res + numArr[cnt]);
                        break;
                    case 1:
                        dfs(cnt + 1, res - numArr[cnt]);
                        break;
                    case 2:
                        dfs(cnt + 1, res * numArr[cnt]);
                        break;
                    case 3:
                        dfs(cnt + 1, res / numArr[cnt]);
                        break;
                }
                operArr[i] += 1;
            }
        }
    }
}