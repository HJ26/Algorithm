
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력값으로 원본 데이터 생성
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		int[] per = new int[n];

		
		for(int i = 0; i < n; i++) {
			per[i] = Integer.parseInt(arr[i]);
		}
		
		// 이전 순열 만들기
		int index = -1;
		for(int i = n-1; i > 0; i--) {     // 순열을 만족하지 않는 부분 구하기
			if ( per[i] < per[i-1] ) {
				index = i-1;
				
				break;
			}
		}
		
		
		if( index == -1 ) { // 최초의 순열이면 그냥 출력하고 끝
			System.out.println(index);

		}else {				// 최초의 순열이 아니면 이전 순열 구하기

			// index에 위치한 값을 기준으로 최소값 구하기
			int j = index+1;
			int max = per[index+1];
			for(int i = index+1; i < n; i++) {
				if( per[index] > per[i] && per[i] > per[j] )
					j = i;
			}
			
			// 가장 작은 값과 index 값 바꾸기
			int tmp = per[index];
			per[index] = per[j];
			per[j] = tmp;

			// 뒤의 부분을 내림차순 정렬
			// 정렬이 필요한 부분만 추출해서 정렬하기

			int[] ans = new int[n-index-1];
			for(int i = 0; i < n-index-1; i++) {
				ans[i] = per[index+1+i];
 			}
			
			Arrays.sort(ans);

			for(int i = 0; i < n-index-1; i++) {
				per[index+1+i] = ans[n-index-2-i];
 			}
			
			// 출력
			for( int i =0; i < n; i++) {
				System.out.print(per[i]+" ");
				
			}
		}
		
	}

}
