import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nWord = Integer.parseInt(br.readLine());
		String[] word = br.readLine().split("");
		int ndiff;
		int nSimiliar = 0;
		for(int i = 0; i < nWord-1; i++) {
			
			ndiff = 0;
			List<String> compareWord = new ArrayList<>(Arrays.asList(br.readLine().split("")));
			
			for( String w : word) {
				
				// 1. 기준 단어와 같은 단어 삭제
				if ( compareWord.contains(w) ) {
					compareWord.remove(w);
				} else {
					ndiff++;
				}
				
			}
			
			// 2. 기준 단어에 없는 단어 확인
			
			
			if ( ndiff > 0 && compareWord.size() > 0) ndiff--;
			ndiff += compareWord.size();
			
			
			
			if( ndiff < 2 ) {
				++nSimiliar;
			}
			

			
		}
		System.out.println(nSimiliar);

	}
}
