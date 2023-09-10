import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int[] tree, arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String input = "";
		// 테스트케이스 개수를 모르므로 입력이 들어올때까지 반복
		while( (input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				
				// 오버플로우 방지
				// 값과 상관없이 양수 음수 0 만 판단 --> 0, 1, -1 로 채우기
				arr[i] = (tmp == 0) ? 0 : (tmp > 0) ? 1 : -1;
			}
			
			// 트리 생성
			tree = new int[N*4];
			
			// 트리 초기화
			init(1,N,1);
			
			// 라운드 반복
			while(K-- > 0) {
				st = new StringTokenizer(br.readLine());
				
				String command = st.nextToken();
				int i = Integer.parseInt(st.nextToken());
				
				// 값 바꾸기
				if(command.equals("C")) {
					int V = Integer.parseInt(st.nextToken());
					V = ( V == 0 ) ? 0 : ( V > 0 ) ? 1 : -1;
					
					update(1,N,1,i,V);
				}else if(command.equals("P")) {	// 양수 음수 판단하기
					int j = Integer.parseInt(st.nextToken());
					long res = mul(1,N,1,i,j);
					sb.append( (res==0) ? 0 : ( res > 0 ) ? "+" : "-");
				}
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 트리 초기화
	public static int init(int start, int end, int node ) {
		// 리프 노드일때
		if( start == end ) {
			return tree[node] = arr[start];
		}
		// 중간 값 구하기
		int mid = ( start+end ) / 2;
		// 자식노드의 곱이 양수인지 음수인지 확인 후 초기화
		return tree[node] = init(start, mid, node*2) * init(mid + 1, end, node*2 + 1);
	}
	
	
	// i 부터 j 까지의 구간곱
	public static int mul(int start, int end, int node, int left, int right) {
		
		if( left > end || right < start ) {
			return 1;
		}
		
		if( left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end)/2;
		return mul(start, mid, node * 2, left, right) * mul(mid+1, end, node*2+1, left, right);
	}
	
	// 값 변경하기
	public static int update(int start, int end, int node, int idx, int val) {
		if(idx < start || idx > end) {
			return tree[node];
		}
		
		if( start == end ) {
			return tree[node] = val;
		}
		
		int mid = (start + end) / 2;
		return tree[node] = update(start, mid, node * 2, idx, val) * update(mid+1, end, node*2 + 1, idx, val);
	}
}
