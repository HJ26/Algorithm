import java.io.*;
import java.util.*;

class Solution {
    static char arr[][];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new char[n][n];

            for (int j = 0; j < n; j++) {
                String str = br.readLine();
                for (int k = 0; k < n; k++) {
                    arr[j][k] = str.charAt(k);
                }
            }

            String result = "NO";
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(arr[j][k] == 'o'){
                        if(right(j, k) || under(j, k) || diagonal1(j, k) || diagonal2(j, k)) {
                            result = "YES";
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag) break;
            }

            sb.append("#" + (i + 1) + " " + result + "\n");
        }

        System.out.println(sb);
    }

    static boolean right(int x, int y) {
        for (int i = 0; i < 5; i++) {
            if ((y + i) >= n || arr[x][y + i] == '.') {
                return false;
            }
        }
        return true;
    }

    static boolean under(int x, int y) {
        for (int i = 0; i < 5; i++) {
            if ((x + i) >= n || arr[x + i][y] == '.') {
                return false;
            }
        }
        return true;
    }

    static boolean diagonal1(int x, int y) {
        for (int i = 0; i < 5; i++) {
            if ((x + i) >= n || (y + i) >= n || arr[x + i][y + i] == '.') {
                return false;
            }
        }
        return true;
    }

    static boolean diagonal2(int x, int y) {
        for (int i = 0; i < 5; i++) {
            if ((x + i) >= n || (y - i) < 0 || arr[x + i][y - i] == '.') {
                return false;
            }
        }
        return true;
    }
}