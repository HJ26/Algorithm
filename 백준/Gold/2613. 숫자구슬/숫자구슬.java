import java.io.*;
import java.util.*;

public class Main {

	public static int N, M, low = -1, high = 0;
	public static int[] beads;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		beads = new int[N];

		st = new StringTokenizer(br.readLine());
		
		
		for(int i = 0; i < N; i++) {

			beads[i] = Integer.parseInt(st.nextToken());
			low = Math.max(low, beads[i]);
			high += beads[i];
			
		}
		
		// 이분탐색을 통해 그룹의 최대값 찾기
		// 어떠한 값을 최대값이라고 지정했을때 M개의 그룹을 만들 수 있는지 체크
		// 만들 수 있으면 더 줄이면서, M개가 안나오는 값까지 확인
		binarySearch();
		
		// 최소최대값 == low --> 출력문에 저장
		sb.append(low).append("\n");
		
		// 그룹별 구슬 개수 출력
		int cnt = 0;
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += beads[i];
			
			// 구슬의 합이 최소최대값보다 커지면 구슬의 수를 출력문에 저장하고 다음 그룹으로 넘어감
			if(sum > low) {
				M--;
				sum = beads[i];
				sb.append(cnt).append(" ");
				cnt = 1;				// 넘어가면서 그룹의 구슬 수를 1로 초기화
			}else {
				cnt++;					// 아니면 그 그룹에 추가하고 다음 구슬 보기
			}
			
			// 남은 묶음의 수가 남은 구슬의 수와 동일하면 종료
			// 지금까지 묶은 구슬을 먼저 출력문에 저장
			if(M == N-i) {
				sb.append(cnt).append(" ");
				cnt = 1;
				M--;
				break;
			}
		}
		
		// 남은 구슬의 개수는 다 묶음 한개이므로 다 묶일때까지 
		while(M-- > 0) sb.append(1).append(" ");
		
		System.out.println(sb.toString());
	}

	// 이중탐색
	private static void binarySearch() {
		
		int mid = 0;
		
		while(low <= high) {
			
			mid = (low + high) / 2;
			
			// 그룹별 최대값을 mid라고 했을때, 만들어지는 그룹 개수 확인
			int cnt = countGroup(mid);
			
			// 그룹이 기준보다 적으면 최대값이 올라가야함
			if(cnt > M) low = mid + 1;
			// 아이면 최대값이 작아져야함
			else high = mid - 1;
		}
	}

	// 그룹 개수 확인
	private static int countGroup(int max) {
		
		int sum = 0;
		int cnt = 1;
		for(int i = 0; i < N; i++) {
			sum += beads[i];
			
			// 그룹의 합계가 기준치를 넘으면 다음 그룹으로 넘김
			if(sum > max) {
				cnt++;
				sum = beads[i];
			}
		}
		return cnt;
	}
	
}
