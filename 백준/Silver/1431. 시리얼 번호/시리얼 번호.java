import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        
        Arrays.sort(arr, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }

            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i) >= '0' && a.charAt(i) <= '9'){
                    sumA += a.charAt(i) - '0';
                }
            }
            for (int i = 0; i < b.length(); i++) {
                if(b.charAt(i) >= '0' && b.charAt(i) <= '9'){
                    sumB += b.charAt(i) - '0';
                }
            }
            if(sumA != sumB) return sumA - sumB;

            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i) != b.charAt(i)) {
                    return a.charAt(i) - b.charAt(i);
                }
            }

            return 0;

        });

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.close();
    }
}