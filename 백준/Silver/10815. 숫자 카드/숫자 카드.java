import java.io.*;
import java.util.*;

public class Main {
	static int[] cards, que, ans;
	static int N, M;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		cards = new int[N];
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		que = new int[M];
		ans = new int[M];
		for(int i = 0; i < M; i++) {
			que[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			findCards(i);
		}
		
		for(int i : ans) System.out.print(i+" ");
	}
	private static void findCards(int idx) {
		
		int left = 0;
		int right = N-1;
		
		while(left <= right) {
			int midIdx = ( left + right ) / 2;
			int mid = cards[midIdx];
			int target = que[idx];
			
			if(target < mid) right = midIdx - 1;
			else if( target > mid) left = midIdx + 1;
			else {
				ans[idx] = 1;
				return;
			}
		}
		
	}
}
