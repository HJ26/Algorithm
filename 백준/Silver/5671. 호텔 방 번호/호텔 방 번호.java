import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str = "";
		Set<Integer> set = new HashSet<>();
		boolean flag = false;

		while ((str = br.readLine()) != null) {
			st = new StringTokenizer(str);

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int result = 0;

			for (int i = a; i <= b; i++) {
				String num = Integer.toString(i);
				flag = false;
				for (int j = 0; j < num.length(); j++) {
					if (set.contains(num.charAt(j) - '0')) {
						flag = true;
						break;
					} else {
						set.add(num.charAt(j) - '0');
					}
				}
				set.clear();
				if (!flag) result += 1;
			}
			sb.append(result + "\n");
		}
        System.out.println(sb.toString());
	}
}