import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Map<String, StringBuilder> map = new LinkedHashMap<>();
		
		String name, distinct;
		StringTokenizer st;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			distinct = st.nextToken();
			
			if (!distinct.equals("-")) {
				if (map.containsKey(distinct)) { 
					map.put(distinct, map.get(distinct).append(" ").append(name));
				} else {
					map.put(distinct, new StringBuilder().append(name));
				}
			}
		}
		
		List<String> names = new LinkedList<>();
		
		for (String s : map.keySet()) {
			st = new StringTokenizer(map.get(s).toString());
			
			if (st.countTokens() == 2) {
				names.add(map.get(s).toString());
			}
		}
		
		sb.append(names.size()).append("\n");
		for (String s : names) {
			sb.append(s).append("\n");
		}

        System.out.println(sb.toString());
	}
}