import java.io.*;
import java.util.*;

class Main {
	public static final int BLANK = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] line = new int[N];
		Arrays.fill(line, BLANK);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int tall = 0; tall < N; tall++) {
			int leftCount = Integer.parseInt(st.nextToken());

			int count = 0;
			for (int i = 0; i < N; i++) {
				if(line[i]==BLANK) {
					if (count == leftCount) {
						line[i] = tall + 1;
						break;
					}
					
					count++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(line[i] + " ");
		}
	}
}