import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		char arr[][] = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			String tmp = "";
			for (int j = 0; j < c; j++) {
				if (arr[i][j] != '#') {
					tmp += arr[i][j];
				} else {
					if (tmp.length() > 1) {
						list.add(tmp);
					}
					tmp = "";
				}
			}
			if (tmp.length() > 1) {
				list.add(tmp);
			}
		}

		for (int i = 0; i < c; i++) {
			String tmp = "";
			for (int j = 0; j < r; j++) {
				if (arr[j][i] != '#') {
					tmp += arr[j][i];
				} else {
					if (tmp.length() > 1) {
						list.add(tmp);
					}
					tmp = "";
				}
			}
			if (tmp.length() > 1) {
				list.add(tmp);
			}
		}

		Collections.sort(list);
		System.out.println(list.get(0));

	}
}