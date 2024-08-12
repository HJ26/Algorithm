import java.io.*;
import java.util.*;

public class Main {

	static int N, minDiff = Integer.MAX_VALUE;
	static int[] liquid, ans = new int[2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		liquid = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 정렬
		Arrays.sort(liquid);
		
		// 찾기
		find(0,N-1);
		
		// 출력
		bw.write(Integer.toString(ans[0]));
		bw.write(" ");
		bw.write(Integer.toString(ans[1]));
		bw.close();
		br.close();
		
	}

	private static void find(int left, int right) {
		
		// 왼쪽이 오른쪽보다 커지거나 같으면 안하고 종료
		if(left >= right) return;
		
		// 두 값의 합과 0과의 거리 구하기
		int curValue = liquid[left] + liquid[right];
		int curDiff = Math.abs(0-curValue);
		
		//  0에 더 가까우면 답 업데이트
		if(curDiff <= minDiff) {
			minDiff = curDiff;
			ans[0] = liquid[left];
			ans[1] = liquid[right];
		}
		
		// 합이 양수이면 수가 더 작아져아 하므로 오른쪽 포인터를 왼쪽으로 옮기기
		// 합이 음수이면 더 큰수가 필요하므로 왼쪽 포인터를 오른쪽으로 옮기기
		if(curValue >= 0) find(left, right-1);
		else find(left+1, right);
	}

}
