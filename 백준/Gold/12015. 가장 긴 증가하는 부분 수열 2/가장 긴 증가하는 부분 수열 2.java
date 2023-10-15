import java.io.*;
import java.util.*;

public class Main {
	static int N, rslt, idx;
	static int[] nums;
	static List<Integer> increase;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		// 데이터 저장할 배열
		nums = new int[N];

		String[] input = br.readLine().split(" ");
		Arrays.setAll(nums, idx -> Integer.parseInt(input[idx]));

		// 증가수열을 저장할 리스트
		increase = new ArrayList<>();
		int size = 0;
		for (int i = 0; i < N; i++) {
			if (i == 0)
				increase.add(nums[i]);
			if (nums[i] > increase.get(size)) {
				increase.add(nums[i]);
				size++;
			} else if (size == 0) {
				increase.set(0, nums[i]);
			} else {
				changeNum(nums[i], 0, size);
			}
		}
		System.out.println(size + 1);
	}

	private static void changeNum(int num, int start, int end) {

		if (start > end) {
			increase.set(end + 1, num);
			return;
		}
		int mid = (start + end) / 2;

		if (increase.get(mid) >= num) {
			changeNum(num, start, mid - 1);
		} else {
			changeNum(num, mid + 1, end);
		}

	}
}
