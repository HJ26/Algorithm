import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	// 최장 부분 문자열 길이 구하기
	public static int subLen(String str, int strlen) {
		
		int[] sublen = new int[strlen] ;
		int max = 0;
		int j = 0; // 접두사 끝지점
		int i = 1; // 접미사 시작부분
		
		while( i < strlen ) {
			if(str.charAt(j) == str.charAt(i)) { // 같은 부분을 찾으면 다음으로 넘어감
				sublen[i] = ++j;
				if(max < sublen[i]) max = sublen[i];	// 최장 길이 구하기
				++i;
			}else {
				if( j > 0) j = sublen[j-1];							// 같지 않으면 그 전 문자와 비교
				else {					// 접두사에 같은 문자가 아예 없으면 접미사 길이 늘리기
					++i;
				}
			}	
		}
		return max;
	}
	
	// 모든 경우의 수의 최장 부분 문자열 길이 구하기
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		int wordLen = word.length();
		int max = 0;
		for(int i = 0; i < wordLen; i++) {
			max = Math.max(max, subLen(word.substring(i, wordLen),wordLen-i));
		}
		
		System.out.println(max);
	}
}
