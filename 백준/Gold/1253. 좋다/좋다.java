import java.io.*;
import java.util.*;

public class Main {
	static int N, good;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 입력값 받기
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		// 입력값을 크기순으로 정렬
		Arrays.sort(nums);
		
		// good 찾기
		// 이분탐색
		// 투포인터
		// 모든 타겟 변수에 대해 확인
		// 왼쪽, 오른쪽 하나씩 바꿔가면서 맞는지 확인
		for(int idx = 0; idx < N; idx++) {
			
			// good 인지 확인할 타겟 변수
			int target = nums[idx];
			
			// 좌우 시작 위치
			int left = 0;
			int right = N-1;
			
			// 두 포인터가 서로 교차되기 전까지 반복
			while(left < right) {
				// 포인터가 가르키는 두 변수의 합
				int sum = nums[left] + nums[right];
				
				// 합이 타겟과 같으면
				if(sum == target) {
					// 타겟 숫자가 합을 이루는 두 수에 포함되어 있지 않은 경우
					// 조건 만족 다음 타겟변수 확인
					if( left != idx && right != idx) {
						good++;
						break;
					}
					else if( left == idx ) {
						// 왼쪽 숫자가 같으면 왼쪽 포인터를 하나 옮기기
						left++;
					}else {
						// 오른쪽 숫자가 같으면 오른쪽 포인터를 하나 옮기기
						right--;
					}
				}else if( sum < target ) {	// 합이 타겟변수보다 작으면
					// 숫자가 더 커져야 하므로
					// 왼쪽 포인터 옮기기
					left++;
				}else { // 합이 타겟변수보다 크면
					// 숫자가 더 작아져야 하므로
					// 오른쪽 포인터 옮기기
					right--;
				}
			}
		}
		
		// 출력
		bw.write(Integer.toString(good));
		bw.close();
		br.close();
		
	}
}
