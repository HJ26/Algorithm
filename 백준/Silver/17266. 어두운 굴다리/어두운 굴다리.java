import java.io.*;
import java.util.*;
 
public class Main {	
    static int N;
    static int[] streetlamp;
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		
        N = Integer.parseInt(br.readLine()); // 굴다리 길이
        int M = Integer.parseInt(br.readLine()); // 가로등 개수
		
        streetlamp = new int[M];
		
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            streetlamp[i] = Integer.parseInt(st.nextToken());
        }
		
        int left = 1; // 굴다리 최소 크기
        int right = N;
        int ans = 0;
		
        while (left <= right) {
            int mid = (left + right) / 2;
			
            if (canLight(mid)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
		
        System.out.println(ans);
    }
	
    public static boolean canLight(int h) {
        int prev = 0;
		
        for (int i=0; i<streetlamp.length; i++) {
            if (streetlamp[i] - h <= prev) {
                prev = streetlamp[i] + h;
            } else {
                return false;
            }
        }
		
        // 마지막 가로등이 비추는 곳이 굴다리 길이보다 같거나 커야함
        return N - prev <= 0;
    }
}