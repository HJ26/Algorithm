import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] line = new int[1000001];

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 구간별 길이 저장
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			for(int j = left+1; j <= right; j++) line[j]++;
		}
		
		
		
		// 같은 점에서 시작
		// 길이가 짧으면 오른쪽으로 이동
		// 길이가 길면 왼쪽이 한칸 앞으로 이동
		// 합이 K 가 되는 구간 찾기
		int start = 0;
		int end = 0;
		long sum = 0;
		
        // 출력할 값을 저장할 변수
		int A = 0, B = 0;
		while(start <= end) {
			
			// 같으면 출력
			if(sum == K) {
				A = start != 0 ? start-1 : start;
				B = end-1;
				break;
			}
			
			// 다르면 구간 바꾸기
            // 종료지점이 마지막 지점을 넘어가면 종료
			if(sum > K) sum -= line[start++];
			else if( end == 1000001 ) break;
			else sum += line[end++];
		}
		
		System.out.println(A+" "+B);
	}
}
