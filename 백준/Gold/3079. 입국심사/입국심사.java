import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int nFriends = Integer.parseInt(st.nextToken());
		
		int[] Time = new int[N];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			Time[i] = Integer.parseInt(br.readLine());
			max = Math.max(Time[i], max);
		}
		
		long left = 0;
		long right = (long)max * nFriends;
		
		long ans = Long.MAX_VALUE;					// 최소 시간을 저장할 변수
		while(left <= right) {						// left와 right의 자리가 바뀔때까지 반복
			// 중간값 구하기
			long mid = (left + right)/2;
			
			// 해당 시간동안 심사할 수 있는 사람의 수 구하기
			long nPerson = 0;
			for(int i : Time) {
				nPerson += mid/i;
				if(nPerson >= nFriends) break;
			}
			
			// 사람수가 많거나 같으면 줄여서 확인
			// 적으면 늘려서 확인
			if( nPerson >= nFriends) {
				ans = mid;	// 검사가 가능했던 시간 저장
				right = mid-1;				// 더 작은값 확인
			}
			else left = mid+1;				// 더 큰값 확인
		}
		
		bw.write(Long.toString(ans));
		bw.close();
		br.close();
	}
}