import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		HashMap<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			int max = 0;
			Long idx = 0L;

			int t = Integer.parseInt(st.nextToken());
			for (int j = 0; j < t; j++) {
				long num = Long.parseLong(st.nextToken());

				if (map.containsKey(num)) {
					map.replace(num, map.get(num) + 1);
				} else {
					map.put(num, 1);
				}

				if (map.get(num) > max) {
					max = map.get(num);
					idx = num;
				}
			}

			if (max > t / 2) {
				bw.write(idx + "\n");
			} else {
				bw.write("SYJKGW\n");
			}

			map.clear();
		}
		bw.flush();
	}
}