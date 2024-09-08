import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] nums = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) nums[i] = Long.parseLong(st.nextToken());
		
		// 크기순으로 정렬
		Arrays.sort(nums);
		
		
		// 탐색 시작
		// 선택한 용액을 저장할 배열
		long[] select = new long[3];
        
        // 용액의 특성값
		long min = Long.MAX_VALUE;
		
		// 시작점을 하나씩 앞당겨가면서 용액 조합 구하기
		// 즉 용액 한개 고정하고, 나머지 두개는 투포인터 방식으로 찾기
		for(int idx = 0; idx < N-2; idx++) {
			
			int left = idx+1;	// nums[idx] 는 고정값. 그 다음이 제일 왼쪽값이므로 idx + 1
			int right = N-1;	// 제일 오른쪽 값
			
			while(left < right) {
				
				long sum = nums[idx] + nums[left] + nums[right];
				long absSum = Math.abs(sum);
				
				// 0 에 더 가까운값 갱신
				if( min > absSum ) {
					select[0] = nums[idx];
					select[1] = nums[left];
					select[2] = nums[right];
					min = absSum;
				}
				
				// 합이 0보다 크면 오른쪽을 왼쪽으로 옮겨서 크기를 더 줄이고
				if(sum > 0) right--;
				// 작으면 왼쪽을 오른쪽으로 옮겨서 크기 키우기
				else left++;
			}
		}
		
		
		// 크기별로 정렬 후 출력
		Arrays.sort(select);
		for(long i : select) sb.append(i).append(" ");
		System.out.println(sb.toString());
	}

}
