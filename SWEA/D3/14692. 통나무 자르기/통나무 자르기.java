import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("#" + tc + " ").append( N%2 == 0 ? "Alice" : "Bob" ).append("\n");
        }
        System.out.println(sb);
	}
}