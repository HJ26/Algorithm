import java.io.*;
import java.util.*;

public class Solution {

	private static class Node {
		long x, y;

		Node(int x, int y) {
			this.x = (long) x;
			this.y = (long) y;
		}
	}

	static int num;
	static long result;
	static Node[] list;
	static boolean[] pick;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int tnum = stoi(br.readLine());
		for (int t = 1; t <= tnum; t++) {
			num = stoi(br.readLine());

			list = new Node[num];
			pick = new boolean[num];
			result = Long.MAX_VALUE;

			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				list[i] = new Node(stoi(st.nextToken()), stoi(st.nextToken()));
			}

			permutation(0, 0);
			System.out.println("#" + t + " " + result);
		}

	}

	private static void permutation(int start, int depth) {
		if (depth == (num >> 1)) {
			result = Math.min(result, calc());
			return;
		}

		for (int i = start; i < num; i++) {
			if (!pick[i]) {
				pick[i] = true;
				permutation(i + 1, depth + 1);
				pick[i] = false;
			}
		}
	}

	private static long calc() {
		long x = 0;
		long y = 0;

		for (int i = 0; i < num; i++) {
			if (pick[i]) {
				x += list[i].x;
				y += list[i].y;
			} else {
				x -= list[i].x;
				y -= list[i].y;
			}
		}

		return x * x + y * y;
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}