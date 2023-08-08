import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str1 = br.readLine().split("");
		String[] str2 = br.readLine().split("");
		
		int lenStr1 = str1.length;
		int lenStr2 = str2.length;
		
		int[][] lcs = new int[lenStr1+1][lenStr2+1];
		
		// LCS 칸 채우기
		for(int i = 1; i < lenStr1+1; i++) {
			for(int j = 1; j < lenStr2+1; j++) {
				if(str1[i-1].equals(str2[j-1])) {
					lcs[i][j] = lcs[i-1][j-1]+1;
				}else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		
		System.out.println(lcs[lenStr1][lenStr2]);
	}
}