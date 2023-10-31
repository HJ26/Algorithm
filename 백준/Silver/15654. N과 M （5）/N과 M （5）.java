import java.io.*;
import java.util.*;

public class Main {
	static int N,M, tmpSize;
	static Set<Integer> tmp;
	static int[] origin, nums;
	static boolean[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());		// 수 개수
		M = Integer.parseInt(st.nextToken());		// 조합 길이
		st = new StringTokenizer(br.readLine());
																			
		tmp = new HashSet<Integer>();				// 중복 숫자 제거 위해 set에 저장
		for(int i =0 ; i < N; i++) {
			tmp.add(Integer.parseInt(st.nextToken()));
		}
		
		tmpSize = tmp.size();					// 중복 제거 후 길이 구하기
		origin = new int[tmpSize];				// 그 수만큼 배열 만들고
		int idx = 0;
		for(int i : tmp) {
			origin[idx++] = i;					// 순서대로 저장
		}
		Arrays.sort(origin);					// 오름차순으로 뽑기 위해 정렬
		
		nums = new int[M];						// 완성된 조합
		visit = new boolean[tmpSize];			// 방문처리할 배열
		combi(0,0);								// 만들기
		bw.close();								// 출력
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

		for(int i = 0; i < tmpSize; i++) {
			if(visit[i]) continue;								// 이미 뽑았으면 pass
			nums[sidx] = origin[i];								// 뽑고
			visit[i] = true;									// 방문처리 하고
			combi(idx+1, sidx+1);								// 다음위치 뽑고
			visit[i] = false;									// 숫자바꿀꺼니까 방문처리 취소
		}
		
	}
}
