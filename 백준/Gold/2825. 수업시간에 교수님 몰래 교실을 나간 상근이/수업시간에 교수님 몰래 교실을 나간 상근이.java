import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] group = new int[1<<10]; 	// 1~9까지의 등장 여부를 판단하기 위한 배열
		int groupSize = group.length;
		for(int i = 0; i < N; i++) {
			String curNum = br.readLine();	// 숫자를 입력받고
			int groupNum = 0; 					// 그 숫자에 포함된 숫자 조합으로 그룹에 넣음
			for(int j = 0; j < curNum.length(); j++) {
				groupNum |= 1 << (curNum.charAt(j)-'0');	// | 연산을 통해 그 숫자에 존재하는 숫자위치를 1로 변경
			}
			group[groupNum]++;	// 최종 그룹 개수 + 1
		}
		
		// 총 개수를 저장할 변수
		long ans = 0;
		
		// 각 그룹을 돌면서 겹치는 숫자가 있으면 그만큼은 친구이므로 결과에 곱한 값 더해주기 
		for(int i = 1; i < groupSize; i++) {
			for(int j = i+1; j < groupSize; j++) {
				// 겹치는 숫자가 없으면 다음 그룹 보기
				if( (i&j) == 0) continue;
				ans += ((long)group[i]*(long)group[j]);
				
			}
			
			// 그 그룹에 속한 값이 2개 이상이면
			// 그 그룹 내의 숫자들도 친구이므로 개수 추가해주기
			if(group[i] >= 2) ans += ((long)group[i]*(long)(group[i]-1)/2);
		}
		
		
		bw.write(Long.toString(ans));
		bw.close();
		br.close();
	}
}
