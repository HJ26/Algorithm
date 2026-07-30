import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		boolean[] isPalendrome = new boolean[32];
        
		for (int i = 1; i < 32; i++) {
			if (check(i) && check((int)Math.pow(i, 2))) {
				isPalendrome[i] = true;
			}
		}
        
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int res = 0;
			int start = (int)Math.ceil(Math.sqrt(Integer.parseInt(st.nextToken())));
			int end = (int)Math.floor(Math.sqrt(Integer.parseInt(st.nextToken())));
			for(int i = start; i <= end ; i++) {
				if(isPalendrome[i])
					res++;
			}
			sb.append("#" + tc + " " + res + "\n");
		}
        System.out.println(sb);
	}

	private static boolean check(int num) {
		String sNum = num + "";
		int cnt = 0;
		while (cnt < sNum.length() / 2) {
			if (sNum.charAt(cnt) != sNum.charAt(sNum.length() - cnt-1))
				return false;
			cnt++;
		}

		return true;
	}
}