import java.io.*;
import java.util.*;

public class Main {
	
	static int[] stack = new int[10001];
	static int idx = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String func = st.nextToken();
			switch(func) {
			case "push":
				int x = Integer.parseInt(st.nextToken());
				push(x);
				break;
			case "pop":
				bw.write(Integer.toString(pop()));
				bw.write("\n");
				break;
			case "size":
				bw.write(Integer.toString(size()));
				bw.write("\n");
				break;
			case "empty":
				bw.write(Integer.toString(empty()));
				bw.write("\n");
				break;
			case "top":
				bw.write(Integer.toString(top()));
				bw.write("\n");
				break;
				
			}
		}
		bw.close();
		
	}
	
	private static void push(int x) {
		stack[++idx] = x;
	}
	
	private static int pop() {
		return idx != -1 ? stack[idx--] : -1;
	}
	
	private static int size() {
		return idx+1;
	}
	
	private static int empty() {
		return idx == -1 ? 1 : 0;
	}
	
	private static int top() {
		return idx != -1 ? stack[idx] : -1;
	}
}
