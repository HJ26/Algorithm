import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		int idx = 0;
		int wordLen = word.length();
		int nWord = 0;
		while(idx < wordLen) {
			if(idx < wordLen-1) {
				switch(word.charAt(idx)) {
				case 'c':
					if(word.charAt(idx+1) == '=' || word.charAt(idx+1) == '-') idx++;
					break;
				case 'd':
					if(idx < wordLen-2 && word.charAt(idx+1) == 'z' && word.charAt(idx+2) == '=') idx = idx+2;
					else if(word.charAt(idx+1)=='-') idx++;
					break;
				case 'l':
				case 'n':
					if(word.charAt(idx+1)=='j') idx++;
					break;
				case 's':
				case 'z':
					if(word.charAt(idx+1)=='=') idx++;
					break;
				}	
			}
			idx++;
			nWord++;
		}
		System.out.println(nWord);
	}
}
