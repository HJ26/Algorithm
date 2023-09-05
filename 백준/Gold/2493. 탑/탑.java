import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nTop = Integer.parseInt(br.readLine());
		int[] top = new int[nTop];
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		String[] tmp = br.readLine().split(" ");
		for(int i = 0; i < nTop; i++) {
			top[i] = Integer.parseInt(tmp[i]);
			map.put(top[i], i+1);
		}
		
		Stack<Integer> receiveTop = new Stack<>();
		receiveTop.add(top[0]);
		sb.append(0).append(" ");
		for(int i = 1; i < nTop; i++) {
			
			if(receiveTop.peek() > top[i]) {
				sb.append(map.get(receiveTop.peek())).append(" ");
				receiveTop.add(top[i]);
			}else {
				int cnt = 0;
				while( !receiveTop.isEmpty() && receiveTop.peek() <= top[i]) {
					receiveTop.pop();
				}
				if(receiveTop.isEmpty()) {
					sb.append(0).append(" ");
				}else {
					sb.append(map.get(receiveTop.peek())).append(" ");
				}
				receiveTop.add(top[i]);
			}
		}
		
		System.out.println(sb.toString());
	}
}
