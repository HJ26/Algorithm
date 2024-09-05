import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 나무 수
		int M = Integer.parseInt(st.nextToken());	// 필요한 나무 길이
		
        // 절단기 높이 ( 구하는 값 )
        // 이분탐색 과정에서 int 크기 넘어가는 경우를 방지하기 위하여 long 선언
        long target = -1;
		
		int[] trees = new int[N]; // 모든 나무의 길이를 저장
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++ ) {
			int hTmp = Integer.parseInt(st.nextToken());
			target = Math.max(target, hTmp);		// 절단기가 가능한 최대 높이 = 가장 높은 나무 높이
			trees[i] = hTmp;						// 리스트에 나무 길이 저장
		}
		
		// 나무 길이 오름차순으로 정렬
		Arrays.sort(trees);
		
		// 변수 선언
		int idx = 0;						// target 보다 큰 나무가 몇번째인지를 저장할 변수
		long left = 0, right = target;		// 이분탐색에 사용될 변수. left = 0, right = target 최대값
		long total = 0;					// 나무를 자르고 내가 가져갈 나무의 길이
		
		// 이분 탐색 시작
		while(left <= right) {
			
			// 중간 구하기
			target = (left + right) / 2;

			// 잘린 나무 길이 구하기
			total = 0;
			for (int i = 0; i < N; i++) {
				// 나무의 길이가 자르려는 기준 길이보다 긴 경우 그 차이를 합에 추가
                if (trees[i] > target) total += trees[i] - target;
            }
			
			// divide 에 따라 좌우 값 변경
			if( total >= M ) left = target+1;
			else right = target-1;
		}
		
		// 최종적으로 나무를 자르는 가장 큰 값은 right
		// right값을 출력
		System.out.println(right);
		
	}
}
