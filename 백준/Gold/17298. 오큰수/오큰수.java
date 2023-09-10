import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		Stack<Integer> nums = new Stack<Integer>();
		int[] nums2 = new int[N];
		
		for(int i = 0 ; i < N; i++) {
			nums2[i] = Integer.parseInt(input[i]);
		}
		
		for(int i = 0; i < N; i++) {
			
			while(!nums.isEmpty() && nums2[nums.peek()] < nums2[i]) {
				nums2[nums.pop()] = nums2[i];
			}
			nums.push(i);
		}
		
		while(!nums.isEmpty()) {
			nums2[nums.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(nums2[i]).append(" ");
		}
		bw.write(sb.toString());
		bw.close();
	}		
}
