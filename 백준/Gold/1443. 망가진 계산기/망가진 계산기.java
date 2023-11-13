import java.io.*;
import java.util.*;

public class Main {
	static int D, P, maxResult = -1, MAX_TARGET;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		D = Integer.parseInt(st.nextToken()); 	// 표시할 자리수
		P = Integer.parseInt(st.nextToken());	// 연산횟수
		MAX_TARGET = (int)Math.pow(10,D);		// 연산으로 나올수 있는 최대값
		
		// 계산
		// 현재 수 : 1, 연산횟수 : 0, 다음에 곱할 수 : 2
		cal(1, 0, 2);
		
		// 출력
		bw.write(Integer.toString(maxResult));
		bw.close();
		br.close();   
	}
	
	// 계산 시작
	private static void cal(int curValue, int curCnt, int lastNum) {
		// 자리수가 넘어가면 리턴
		if(curValue >= MAX_TARGET) return;
		
		// P번 곱했으면 최대값 업데이트
		if(curCnt == P) {
			maxResult = Math.max(maxResult, curValue);
			return;
		}
		
		// 타겟숫자에 대하여 곱하기 실행
		// 이전 연산에서 곱한 수를 기준으로 같거나 큰값만 이어서 곱해줌
		// ==> 중복 연산 제외
		for(int i = lastNum; i < 10; i++) {
			cal( curValue * i, curCnt + 1, i);
		}
		
	}
}
