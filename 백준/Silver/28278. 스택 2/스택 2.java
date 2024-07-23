import java.io.*;
import java.util.*;

public class Main {
	
	static int[] stack = new int[1000001];
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
			case "1":
				int x = Integer.parseInt(st.nextToken());
				push(x);
				break;
			case "2":
				bw.write(Integer.toString(pop()));
				bw.write("\n");
				break;
			case "3":
				bw.write(Integer.toString(size()));
				bw.write("\n");
				break;
			case "4":
				bw.write(Integer.toString(empty()));
				bw.write("\n");
				break;
			case "5":
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
		
		int number = -1;
		if(idx != -1) {
			number = stack[idx--];
		}
		
		return number;
	}
	
	private static int size() {
		return idx+1;
	}
	
	private static int empty() {
		return idx == -1 ? 1 : 0;
	}
	
	private static int top() {
		int number = -1;
		if(idx != -1) {
			number = stack[idx];
		}
		return number;
	}
}
