import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		String str = bf.readLine();

		Stack<Character> sStack = new Stack<>();
		Stack<Character> lStack = new Stack<>();
		int result = 0;

		for (int i = 0; i < n; i++) {
			char x = str.charAt(i);
			if (Character.isDigit(x)) {
				result += 1;
			} else if (x == 'L') {
				lStack.add(x);
			} else if (x == 'S') {
				sStack.add(x);
			} else if (x == 'R') {
				if (!lStack.isEmpty()) {
					lStack.pop();
					result += 1;
				} else {
					break;
				}
			} else if (x == 'K') {
				if (!sStack.isEmpty()) {
					sStack.pop();
					result += 1;
				} else {
					break;
				}
			}
		}
		System.out.println(result);
	}
}