import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	
	// 뒤집기
	public static String[] funcR(String[] arr) {
		String[] rslt = new String[arr.length];
		for(int i = 0; i < arr.length; i++) {
			rslt[i] = arr[arr.length-i-1];
		}
		return rslt;
	}
	
	// 버리기
	public static String[] funcD(String[] arr, int left, int right) {
		// right = 오른쪽에서 빠질 개수
		// left  = 왼쪽에서 빠질 개수
		
		int rsltLen = arr.length-right-left;
		if(rsltLen < 0) return null;
		String[] rslt = new String[rsltLen];

		for(int i = left; i < rsltLen+left; i++ ) {
			rslt[i-left] = arr[i];
		}

		return rslt;
	}
	

	// 시행
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] result = new String[n][];
				
		// 전체 테스트 케이스 반복
		for(int i = 0; i < n; i++) {
			
			// 시행할 함수 + 원본 배열
			String[] func = br.readLine().split("");   								// 함수집합
			int len = Integer.parseInt(br.readLine());								// 원본 길이
			String[] arr = new String[len];
			
			arr = ((br.readLine()).replaceAll("[\\[\\]]","")).split(",");
			
			if (len == 0 ) { 														// null 체크
				arr = new String[0]; 
			} 
			// 함수 적용
			// 내가 해야하는 행동 정리
			
			
			// 0 : 왼쪽에서 삭제
			// 1 : 오른쪽에서 삭제
			int flag = 0;
			int left = 0;
			int right = 0;
			for(String j : func) {
				switch(j) {
				case "R":
					if(flag == 0) flag = 1;
					else flag = 0;
					break;
				case "D":
					if (flag == 0 ) left++;
					else right++;
					break;
				}
			}
			
			// 함수 행동 시행

			String[] rslt = funcD(arr,left,right);

			if(flag == 1 && rslt != null) rslt = funcR(rslt);

			
			result[i] = rslt;
		}
		for(int i = 0; i < n; i++) {
			if(result[i]==null) System.out.println("error");
			else System.out.println(Arrays.toString(result[i]).replaceAll(" ", ""));
		}
	}
}
