import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> word = new Stack<>();
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		boolean sbFlag = false;
		
		for(int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if(tmp == '<') {
				while(!word.isEmpty()) {
					sb.append(word.pop());
				}
				sbFlag = true;
			}else if(tmp == '>') {
				sb.append(tmp);
				sbFlag = false;
				continue;
			}
			if(sbFlag) sb.append(tmp);
			else {
				if(tmp == ' ') {
					while(!word.isEmpty()) {
						sb.append(word.pop());
					}
					sb.append(' ');
				}else {
					word.push(tmp);					
				}
			}
		}
		while(!word.isEmpty()) {
			sb.append(word.pop());
		}
		System.out.println(sb.toString());
	}
}
