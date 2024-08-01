import java.io.*;
import java.util.*;

public class Main {

	static char[] alphabet = new char[27];
	static boolean[] visited;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		
		for(int  i = 0; i < str.length(); i++)
			alphabet[str.charAt(i) - 'a']++;

		dfs(0, "", str.length());
		
		System.out.println(result);
		
	}
    
    public static void dfs(int idx, String temp, int len) {
		
		if(idx == len) {
			result++;
			return;
		}
		
		for(int i = 0; i < 26; i++) {
			if(alphabet[i] == 0)
				continue;
			if(temp != "" && temp.charAt(temp.length() - 1) == (char)('a' + i))
				continue;
			alphabet[i]--;
			dfs(idx + 1, temp + (char)('a' + i), len);
			alphabet[i]++;
		}
	}
	
}