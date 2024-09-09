import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] students = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) students[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(students);
		
		int coding = 0;
		long ans = 0;
		
		for(int i = 0; i < N-1; i++) {
			
			// 최소값이 0 이상이면 0을 절대 만들 수 없으므로 멈추기
			if(students[i] > 0) break;
			int left = i+1;
			int right = N-1;
			
			while(left < right) {
				
				coding = students[i] + students[left] + students[right];
				
				if(coding == 0) {
					
					// 시작점과 끝점의 값이 모두 같은경우
					// 조합으로 개수찾기
					if(students[left] == students[right]) {
						int n = (right-left+1);
						ans += (n)*(n-1)/2;
						break;
					}
					
					// 시작점과 끝점의 두 값이 다른 경우
					// 좌 우 의 연속된 값의 개수만 찾아서 쌍 개수 찾기

					// 좌 우 연속된 값의 개수를 저장할 변수
					int nl = 1;
					int nr = 1;
					
					while(left+1 < right && students[left] == students[left+1]) {
						nl++;
						left++;
					}
					
					while(right-1 > left && students[right] == students[right-1]) {
						nr++;
						right--;
					}
					
					// 연속된 값으로 찾을 수 있는 모든 경우의 수
					ans += nl * nr;
					
				}
				
				if(coding > 0) right--;
				else left++;
	 		}
		}
		
		System.out.println(ans);
	}
}
