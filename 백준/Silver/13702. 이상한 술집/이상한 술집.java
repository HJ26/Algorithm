import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {
	static int N, M, S, P, K;
	static int answer = 0;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int max = 0;
		arr = new int[N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		System.out.println(optimize(1, max));
	}
	
	static boolean isDivideable(long value) {
		
		int cnt = 0;
		for(int i=0;i<N;i++) {
			cnt += arr[i] / value;
		}
		return cnt >= K; 
	}
	static long optimize(int lo, int hi) {
		long left = lo - 1; 
		long right = hi + 1;
 
		while(left + 1 < right) {
			long mid = (left + right) / 2;
			if(isDivideable(mid)) {
				left = mid;
			}else {
				right = mid;
			}
		}
		return right - 1;
	}
	
}