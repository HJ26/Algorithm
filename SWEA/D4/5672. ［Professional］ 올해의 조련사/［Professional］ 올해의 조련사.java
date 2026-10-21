import java.io.*;

public class Solution {
    private int N;
    private char[] arr;
    private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        new Solution().io();
    }

    private void io() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[N];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().charAt(0);
            }
            sb.append("#").append(tc).append(" ");
            sol();
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private void sol() {
        int i = 0, j = N-1;
        while(i < j) {
            if (arr[i] < arr[j]) sb.append(arr[i++]);
            else if (arr[i] > arr[j]) sb.append(arr[j--]);
            else {
                sb.append(arr[i]);
                if(check(i+1, j-1)) i++;
                else j--;
            }
        }
        sb.append(arr[i]).append("\n");
    }

    private boolean check(int i, int j) {
        if (i >= j) return true;
        if (arr[i] < arr[j]) return true;
        if (arr[i] > arr[j]) return false;
        return check(i+1, j-1);
    }
}