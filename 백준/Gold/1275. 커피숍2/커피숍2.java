import java.io.*;
import java.util.*;


public class Main {
	
	static long[] tree;
	static int[] arr;
	static int N, Q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		tree = new long[ N*4 ];
		init(1,N,1);
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if( x > y ) {
				int tmp = y;
				y =  x;
				x = tmp;
			}
			
			sb.append(add(1,N,1,x,y));
			sb.append("\n");
			update(1,N,1,a,b);
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	// 초기 구간합 저장
	public static long init(int start, int end, int node) {
		if( start == end ) {
			return tree[node] = arr[start];
		}
		int mid = ( start + end ) / 2;
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2 + 1);
	}
	
	// 특정 구간합
	public static long add(int start, int end, int node, int left, int right) {
		if (end < left || right < start) {
			return 0;
		}

		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		return add(start, mid, node * 2, left, right) + add(mid + 1, end, node * 2 + 1, left, right);
	}
	
	// 값 변경
	public static long update(int start, int end, int node, int idx, long val) {
		if (idx < start || idx > end) {
			return tree[node];
		}
		
		if (start == end) {
			return tree[node] = val;
		}
		
		int mid = (start + end) / 2;
		return tree[node] = update(start, mid, node * 2, idx, val) + update(mid + 1, end, node * 2 + 1, idx, val);
	}
}
