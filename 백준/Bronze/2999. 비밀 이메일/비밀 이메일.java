import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String words = br.readLine();
		int nWord = words.length();
		
		// R,C 구하기
		int R = 1;
		int C = nWord;
		for(int i =1; i < nWord; i++) {
			if(nWord % i == 0) {
				if( i > nWord/i ) break;
				R = i;
				C = nWord/i;
			}
		}

		// 복호화
		StringBuilder origin = new StringBuilder();
		int visit[] = new int[nWord];
		for(int i =0, cnt = 0; cnt < nWord; i = i+R,cnt++) {
			while(visit[i%nWord] == 1) {
				i++;
			}
			origin.append(words.charAt(i%nWord));
			visit[i%nWord] = 1;
		}
		
		System.out.println(origin.toString());
	}
}
