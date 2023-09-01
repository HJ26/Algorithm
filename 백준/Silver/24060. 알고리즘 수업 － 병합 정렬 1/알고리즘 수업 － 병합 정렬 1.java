import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int K;
	public static int cnt = 0;
	public static int[] nums;
	public static int[] sortNums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		StringTokenizer numTmp = new StringTokenizer(br.readLine());
		nums = new int[N];
		sortNums = new int[N];
		for(int i =0; i < N; i++) {
			nums[i] = Integer.parseInt(numTmp.nextToken());
		}
		mergeSort(0,N-1);
		System.out.println(-1);
	}
	
	public static void mergeSort(int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	public static void merge(int left, int mid, int right) {
		int l = left;
		int r = mid+1;
		int idx = left;
		while( l <= mid && r <= right) {
			if( nums[l] <=  nums[r] ) sortNums[idx++] = nums[l++];
			else sortNums[idx++] = nums[r++];
		}
		
		if( l <= mid ) {
			for(int i = l; i <= mid; i++) {
				sortNums[idx++] = nums[i];
			}
		}else {
			for(int i = r; i <= right; i++) {
				sortNums[idx++] = nums[i];
			}
		}
		
		for(int i = left; i <= right; i++) {
			nums[i] = sortNums[i];
			cnt++;
			if(cnt == K) {
				System.out.println(nums[i]);
				System.exit(0);
			}
		}
	}
	
}