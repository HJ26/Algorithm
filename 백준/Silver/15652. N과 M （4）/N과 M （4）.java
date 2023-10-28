import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] nums;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());		// 수 최대값
		M = Integer.parseInt(st.nextToken());		// 조합 길이
		nums = new int[M];							// 완성된 조합
		combi(1,0);									// 만들기
		bw.close();									// 출력
		br.close();
	}
	private static void combi(int idx, int sidx) throws IOException {
		if(sidx == M) {											// M개 다 뽑았으면
			for(int i = 0; i < M; i++) {						// 값 순서대로 입력하고
				bw.write(Integer.toString(nums[i]));
				bw.write(" ");
			}
			bw.write("\n");										// 버퍼라이터에 저장
			return;												// 함수 종료
		}

		for(int i = idx; i <= N; i++) {							// 조합 숫자 고르기
			nums[sidx] = i;
			combi(i, sidx+1);
		}
		
	}
}
