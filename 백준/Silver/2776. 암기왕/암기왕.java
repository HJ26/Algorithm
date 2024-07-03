import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(binarysearch(arr, x)+"\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static int binarysearch(int[] arr, int x) {
        int min = 0;
        int max = arr.length - 1;
        int mid = (min + max) / 2;

        while (min <= max) {
            mid = (min + max) / 2;
            if(arr[mid] == x){
                return 1;
            }
            if (arr[mid] < x) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return 0;
    }
}