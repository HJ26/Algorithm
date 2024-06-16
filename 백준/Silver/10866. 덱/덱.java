import java.io.*;
import java.util.*;

public class Main {
	
	static int[] deque = new int[20001];
	static int startIdx = 10000, endIdx = 10000, size = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push_front":
				push_front(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				push_back(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				bw.write(Integer.toString(pop_front()));
				bw.write("\n");
				break;
			case "pop_back":
				bw.write(Integer.toString(pop_back()));
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
	
	private static void push_front(int x) {
		deque[startIdx--] = x;
		size++;
	}
	
	private static void push_back(int x) {
		deque[++endIdx] = x;
		size++;
	}
	
	private static int pop_front() {
		int ret = -1;
		if(size != 0) {
			ret = deque[++startIdx];
			size--;
		}
		return ret;
	}
	
	private static int pop_back() {
		int ret = -1;
		if(size != 0) {
			ret = deque[endIdx--];
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
		return size == 0 ? -1 : deque[startIdx+1];
	}
	
	private static int back() {
		return size == 0 ? -1 : deque[endIdx];
	}
	
}
