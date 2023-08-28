import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nProject = Integer.parseInt(br.readLine());
		
		// 과제 정보 받기
		int[][] projects = new int[nProject][2];
		for(int i = 0; i < nProject; i++) {
			String[] tmp = br.readLine().split(" ");
			projects[i][0] = Integer.parseInt(tmp[0]);
			projects[i][1] = Integer.parseInt(tmp[1]);
		}
		
		// 마감 날짜가 많이 남은 과제부터 확인
		// 점수 별로 정렬
		int max = projects[0][0];
		for(int i = 0; i < nProject; i++) {
			if(max < projects[i][0]) max = projects[i][0];
		}
		
		// 카운팅
		int[] cnt = new int[max+1];
		for(int i = 0; i < nProject; i++) {
			cnt[projects[i][0]]++;
		}
		
		// 누적합
		for(int i = max-1; i >= 0; i--) {
			cnt[i] += cnt[i+1];
		}
		
		// 원본 데이터 정렬
		int[][] sortArr = new int[nProject][2];
		for(int i = nProject -1; i >= 0; i--) {
			int tmp = --cnt[projects[i][0]];
			sortArr[tmp][0] = projects[i][0];
			sortArr[tmp][1] = projects[i][1];
		}
		
		int days = sortArr[0][0];
		int totalScore = 0;
		while(days > 0) {
			
			int maxScore = 0, maxIdx = 0;
			for(int i = 0; i < nProject; i++) {
				if( sortArr[i][0] < days ) break;
				if( maxScore < sortArr[i][1] ) {
					maxScore = sortArr[i][1];
					maxIdx = i;
				}
			}
			totalScore += maxScore;
			sortArr[maxIdx][1] = 0;
			days--;
			
		}
		
		System.out.println(totalScore);
	}
}
