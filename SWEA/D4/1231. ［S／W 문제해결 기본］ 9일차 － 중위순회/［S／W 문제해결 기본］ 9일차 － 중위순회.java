import java.util.*;
import java.io.*;

public class Solution {
	static char[] arr;
    static StringBuilder sb = new StringBuilder();
	static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N + 1];
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				arr[i] = st.nextToken().charAt(0);
			}
			sb.append("#" + tc + " ");
            inOrder(1);
            sb.append("\n");
		}
        System.out.println(sb);
	}
    
    public static void inOrder(int idx) {
		if(idx > N) return; 
		inOrder(2 * idx);
		sb.append(arr[idx]);
		inOrder(2 * idx + 1);
	}
    
}