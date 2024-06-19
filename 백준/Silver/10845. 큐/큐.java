import java.io.*;
import java.util.*;

public class Main {
	
	static int[] queue = new int[10001];
	static int startIdx = 0, endIdx = 0, size = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
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
			case "front":
				bw.write(Integer.toString(front()));
				bw.write("\n");
				break;
			case "back":
				bw.write(Integer.toString(back()));
				bw.write("\n");
				break;
			}
		}
		bw.close();
	}
	
	private static void push(int x) {
		queue[endIdx++] = x;
		size++;
	}
	
	private static int pop() {
		int ret = -1;
		if(size != 0) {
			ret = queue[startIdx++];
			size--;
		}
		return ret;
	}

	private static int size() {
		return size;
	}
	
	private static int empty() {
		return size == 0 ? 1 : 0;
	}
	
	private static int front() {
		return size == 0 ? -1 : queue[startIdx];
	}
	
	private static int back() {
		return size == 0 ? -1 : queue[endIdx-1];
	}
	
}

