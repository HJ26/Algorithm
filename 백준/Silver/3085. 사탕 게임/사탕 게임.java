import java.util.*;
import java.io.*;

public class Main {
    
    static int N, max=1;
    static char[][] arr;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        searchRow();
        searchCol();
        bw.write(Integer.toString(max));
        bw.close();
        br.close();

    }
    
    public static void searchRow() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                swap(i, j, i, j+1);
                rowCheck();
                colCheck();
                swap(i, j+1, i, j);
            }
        }
    }
    
    public static void searchCol() {
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i+1, j);
                rowCheck();
                colCheck();
                swap(i+1, j, i, j);
            }
        }
    }
    
    public static void rowCheck() {
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N-1; j++) {
                if (arr[i][j] == arr[i][j+1]) {
                    cnt++;
                    max = Math.max(max, cnt);
                }
                else {
                    cnt = 1;
                }
            }
        }
    }
    
    public static void swap(int x1, int y1, int x2, int y2) {
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }
    
    public static void colCheck () {
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N-1; j++) {
                if (arr[j][i] == arr[j+1][i]) {
                    cnt++;
                    max = Math.max(max, cnt);
                }
                else {
                    cnt = 1;
                }
            }
        }
    }
}
