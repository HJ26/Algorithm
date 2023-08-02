import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		
		// 숫자 집합 만들기
		List<Integer> rslt = new ArrayList<Integer>();
		for(int i = 2; i < n+1; i++) {
			rslt.add(i);
		}
		
		// 소수 지우기
		
		// 가장 작은 수부터 삭제 시작
		int startNum = 2;
		int count = 2;
		int tmp = startNum;
		int len = rslt.size()-1;
		
		while( k > 0 ) {
			
			// 값이 있으면 지우고 횟수 차감
			if(rslt.contains(tmp)) {
				rslt.remove(Integer.valueOf(tmp));
				len -= 1;
				k -= 1;
				if(k == 0) {
					System.out.println(tmp);
					break;
				}
			}
			// 다음 배수로 이동
			tmp = startNum * count;
			
			// 더이상 배수가 존재하지 않으면 제일 작은 값으로 초기화 
			if( tmp > rslt.get(len) ) {
				count = 2;
				startNum = rslt.get(0);
				tmp = startNum;
			}
			count++;	
		}
		
	}
}
