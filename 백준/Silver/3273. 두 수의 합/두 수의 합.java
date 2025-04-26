import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int target = Integer.parseInt(br.readLine());
		
		int left = 0;
		int right = N-1;
		int cnt = 0;
		while(left < right) {
			int sum = nums[left] + nums[right];
			
			if(sum < target) left++;
			else if(sum > target) right--;
			else {
				cnt++;
				left++;
				right--;
			}
		}
		
		System.out.println(cnt);
	}
}
