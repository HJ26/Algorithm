import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			Integer[] arr = new Integer[N];
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, Collections.reverseOrder());

			int max = arr[0];
			int min = arr[N - 1];
			int gap = 0;
			for (int k = 1; k < N; k++) {
				int diff = Math.abs(arr[k] - arr[k - 1]);
				gap = Math.max(gap, diff);
			}

			sb.append("Class ").append(i + 1).append(System.lineSeparator());
			sb.append(String.format("Max %d, Min %d, Largest gap %d\n", max, min, gap));
		}

		System.out.println(sb);
	}
}