import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] nums = new int[N];
		Arrays.setAll(nums, idx -> Integer.parseInt(input[idx]));
		
		int[] sub = new int[N];
		sub[0] = nums[0];
		int len = 1;
		
		
		for(int i = 1; i < N; i++) {
			if(nums[i] > sub[len-1]) {
				sub[len++] = nums[i];
			}else {
				int left = 0;
				int right = len;
				while(left < right) {
					int mid = (left + right)/2;
					if(sub[mid] >= nums[i]) right = mid;
					else left = mid+1;
				}
				sub[left] = nums[i];
			}
		}
		
		System.out.println(N-len);
	}
}