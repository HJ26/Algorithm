
import java.io.*;
import java.util.*;

public class Main {
	
	static int[] tree, lights, firstMax;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		lights = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			lights[i] = Integer.parseInt(st.nextToken());
		}
		
		tree = new int[N*4];
		init(1,N,1);
		
		for(int start = M; start <= N-M+1; start++) {		
			sb.append(getMax(1,N,1,start-(M-1),start+(M-1))).append(" ");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}
	
	private static int getMax(int start, int end, int Node, int left, int right) {
		
		if(end < left || start > right ) return -1;
		
		if(start >= left && end <= right ) {
			return tree[Node];
		}
		
		int mid = (start+end) >> 1;
		return Math.max(getMax(start,mid,Node*2,left,right),getMax(mid+1,end,Node*2+1,left,right));
		
	}


	private static int init(int start, int end, int Node) {
		
		if(start == end) return tree[Node] = lights[start];
		
		int mid = (start+end) >> 1;
		
		return tree[Node] = Math.max(init(start, mid, Node*2),init(mid+1, end, Node*2+1));
		
	}
	
}
