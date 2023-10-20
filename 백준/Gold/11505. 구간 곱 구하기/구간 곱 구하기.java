import java.io.*;
import java.util.*;

public class Main {
	static int[] nums;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 원본 숫자 배열
		nums = new int[N + 1];
		// 채우기
		for (int i = 1; i <= N; i++)
			nums[i] = Integer.parseInt(br.readLine());

		// 트리 사이즈 구하기

		int TN = (int) (Math.ceil(Math.log(N) / Math.log(2))) + 1;
		tree = new long[(int) Math.pow(2, TN)];
		Arrays.fill(tree, 1);

		// 구간 곱으로 초기화하기
		init(1, N, 1);

		// 값 바꾸기
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			String mode = st.nextToken();
			switch (mode) {
			case "1":

				int idx = Integer.parseInt(st.nextToken());
				int changeNum = Integer.parseInt(st.nextToken());
				nums[idx] = changeNum;

				update(1, N, 1, idx);

				break;

			case "2":

				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				sb.append(findMulti(1, N, 1, left, right) % 1000000007).append("\n");
				break;
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

	private static long findMulti(int start, int end, int Node, int left, int right) {

		if (start > right || end < left)
			return 1;

		if (start >= left && end <= right)
			return tree[Node];

		int mid = (start + end) >> 1;
		return (findMulti(start, mid, Node * 2, left, right) % 1000000007 * findMulti(mid + 1, end, Node * 2 + 1, left, right) % 1000000007 ) % 1000000007;
	}

	private static void update(int start, int end, int Node, int idx) {

		// 바꾸려는 수가 찾으려는 범위 밖이면 그냥 리턴
		if (start > idx || end < idx)
			return;

		if (start == end) {
			tree[Node] = nums[idx];
			return;
		}

		int mid = (start + end) >> 1;
		update(start, mid, Node * 2, idx);
		update(mid + 1, end, Node * 2 + 1, idx);
		tree[Node] = ((tree[Node * 2] % 1000000007) * (tree[Node * 2 + 1]% 1000000007)) % 1000000007;

	}

	private static long init(int start, int end, int Node) {

		if (start == end)
			return tree[Node] = nums[start];

		int mid = (start + end) >> 1;

		return tree[Node] = init(start, mid, Node * 2) * init(mid + 1, end, Node * 2 + 1) % 1000000007;

	}
}
