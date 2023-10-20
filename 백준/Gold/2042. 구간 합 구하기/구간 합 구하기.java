import java.io.*;
import java.util.*;

public class Main {
	// nums : 입력순으로 저장 tree : 구간합을 저장할 배열
	static long[] nums, tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int N, M, K;
		// N : 수의 개수 , M : 수의 변경 횟수, K : 구간의 합
		
		// N,M,K 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// nums 입력받기
		nums = new long[N+1];
		for(int i = 1; i <= N; i++) nums[i] = Long.parseLong(br.readLine());
		
		// tree 설정
		
		// 2^TN >= N 인 최소 TN 찾기 --> 이 2^TN 이 트리 배열의 크기
		// 왜 이렇게 하는가? tree 는 각자 자식노드가 최대 2개씩 존재 --> 이게 다 존재할 수 있도록 크기 설정
		
		// 2^TN ==> log(2^TN) ==> TN
		// 즉, TN = log(N)/log(2) ==> 을 구해야함
		// TN은 같거나 큰 값이므로 올림하고 + 1
		
		int TN = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int size = (int) Math.pow(2, TN);
		tree = new long[size];				// tree = new int[N*4] 해도 문제 없음
		
		// 트리 초기화 ( 구간합 )
		// 1번부터 N번 구간에 대하여 합을 구할건데, 1번 인덱스에 값이 들어감
		init(1,N,1);

		// 값 변경하기
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int mode = Integer.parseInt(st.nextToken());
			switch (mode) {
			case 1:													// 숫자를 변경하는 경우
				int idx = Integer.parseInt(st.nextToken());				// 변경하려는 값의 위치 ( nums 에서 )
				long changeNum = Long.parseLong(st.nextToken());		// 변경하려는 수
				long diff = changeNum-nums[idx];						// 변경하려는 수와 원래 값의 차이
				nums[idx] = changeNum;									// 원래 수 배열 변경
				update(1,N,1,idx,diff);									// 1번부터 N번까지 중에 idx 위치에 있는 값을 찾아서 changeNum으로 변경하고, 해당 값이 포함되는 구간의 구간합도 변경
				break;
			case 2:													// 구간합을 구하는 경우
				int left = Integer.parseInt(st.nextToken());			// 원하는 구간 시작점
				int right = Integer.parseInt(st.nextToken());			// 원하는 구간 종료점
				sb.append(findSum(1,N,1,left,right)).append("\n");		// findSum ( 탐색구간시작점, 탐색구간종료점, 트리인덱스, 찾아야하는구간시작점, 찾아야하는구간 종료점 )
				break;
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	



	// start, end : 내가 확인하고 있는 구간의 시작점과 끝점
	// left, right : 합을 구하고 싶은 구간의 시작점과 끝점
	private static long findSum(int start, int end, int idx, int left, int right) {
		
		// 찾으려는 구간( start, end )이 찾아야하는 구간 ( left, right ) 밖인 경우
		if(left > end || right < start) return 0;
		// 찾으려는 구간안에 내가 보고있는 구간이 포함되어 있는 경우
		if(left <= start && right >= end) return tree[idx];
		
		// 포함되어 있지 않으면 양쪽 확인
		int mid = (start+end)/2;
		return findSum(start, mid, idx*2, left, right) + findSum(mid+1, end, idx*2+1, left, right);
	}




	// 값 변경
	private static void update(int start, int end, int node, int idx, long diff) {
		
		// 업데이트 하려는 값의 위치가 현재 구간 밖에 있을 경우
		if(idx < start || idx > end ) return;
		
		// 범위 안에 있으면 값 변경
		tree[node] += diff;
		if(start == end) return;
		
		// 왼쪽자식, 오른쪽 자식 탐색
		int mid = (start+end)/2;
		update(start, mid, node*2,  idx, diff);
		update(mid+1, end, node*2+1,idx, diff);
		
		
		
	}


	// 구간 합 구해서 채우기
	private static long init(int start, int end, int idx) {
		// 구간의 길이가 1이면
		if(start == end) {
			return tree[idx] = nums[start];
		}
		
		// 아니면 구간에서 중간값을 기준으로 나눠서 합 구하기
		int mid = (start + end)/2;
		
		return tree[idx] = init(start,mid,idx*2) + init(mid+1, end, idx*2+1);
	}
	
	
}
