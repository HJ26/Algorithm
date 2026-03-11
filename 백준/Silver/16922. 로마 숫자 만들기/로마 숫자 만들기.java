import java.io.*;

public class Main {
    static int[] lomeArr = {1, 5, 10, 50};
    static boolean[] isVisited;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사용 할 수 있는 문자 개수
        isVisited = new boolean[4845];

        dfs(0, N, 0, 0);
        System.out.print(result);
    }

    private static void dfs(int depth, int depthLimit, int indexStart, int sum) {
        
        if (depth == depthLimit) {
            if(!isVisited[sum]) {
                isVisited[sum] = true;
                result++;
            }
            return;
        }

        for (int i = indexStart; i < 4; i++) {
            dfs(depth + 1, depthLimit, i, sum + lomeArr[i]);
        }
    }
}