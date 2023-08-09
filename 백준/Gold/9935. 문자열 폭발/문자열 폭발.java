import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		String bombWord = br.readLine();
		int wordLen = word.length();
		int bombLen = bombWord.length();
		
		Stack<Character> words = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		word : for(int i = 0; i < wordLen; i++) {
			words.push(word.charAt(i));
			
			// 문자열의 개수 > 폭발 문자열 -> 폭발 문자열이 존재할 가능성이 있는 경우
			if(words.size() >= bombLen) {
				
				// 폭발문자가 있는지 확인
				for( int j = 0; j < bombLen; j++) {
					
					if( !( words.get( words.size()- bombLen + j ) == bombWord.charAt(j)) ) {	// 폭발 문자열 비교
						continue word;															// 다른게 있으면 그냥 넘어가기
					}
				}
				
				// 폭발 문자가 있을 때만 실행
				for( int k = 0; k < bombLen; k++) {
					words.pop();
				}
			}
		}
		
		if(words.size() == 0) {
			System.out.println("FRULA");
		}else {
			for(char ch : words) {
				sb.append(ch);
			}
		}
		System.out.println(sb);
	}
}