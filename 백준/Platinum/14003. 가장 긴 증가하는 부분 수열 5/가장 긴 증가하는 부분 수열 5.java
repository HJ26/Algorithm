import java.io.*;
import java.util.*;

public class Main {
	static int[][] sub;
	static int size;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		sb = new StringBuilder();
		sub = new int[N][2]; // 부분수열을 저장할 리스트

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(input[i]);
			sub[i][1] = i;
		}

		// 수열 길이 확인하기
		dp = new int[N]; // 수열에서 내 값 이전에 오는 값의 idx 를 저장할 배열
		size = 1;
		sub[0][0] = nums[0];
		sub[0][1] = 0;
		for (int i = 1; i < N; i++) {
			int target = nums[i];
			if (target > sub[size - 1][0]) {
				sub[size][0] = target;
				sub[size][1] = i;
				dp[i] = sub[size - 1][1];
				size++;
			} else
				binarySearch(i, target, 0, size - 1);
		}

		sb.append(Integer.toString(size)).append("\n");
		
		int[] rslt = new int[size];
		int cnt = size-1;
		rslt[cnt] = nums[sub[cnt][1]];

		
		int idx = dp[sub[size - 1][1]];
		while (cnt-- > 0) {
			rslt[cnt] = nums[idx];
			idx = dp[idx];
		}

		for(int i : rslt) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}

	private static void binarySearch(int idx, int target, int left, int right) {

		while (left < right) {
			int mid = (left + right) / 2;
			if (target > sub[mid][0])
				left = mid + 1;
			else
				right = mid;
		}
		sub[left][0] = target;
		sub[left][1] = idx;
		if (left > 0)
			dp[idx] = sub[left - 1][1];
	}

}