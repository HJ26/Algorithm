import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[] isPrime = new boolean[10000];
	public static int[] cnt;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	// 0:소수  1: 소수아님
	static {
		for(int i = 2; i < 10000; i++) {
			int j = 2;
			if( !isPrime[i] ) {
				while(i*j < 10000) {
					isPrime[i*j] = true;
					j++;
				}				
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startNum = Integer.parseInt(st.nextToken());
			int endNum = Integer.parseInt(st.nextToken());
			cnt = new int[10000];
			visit = new boolean[10000];
			int min = BFS(startNum, endNum);
			if(min == -1) sb.append("Impossible");
			else sb.append(min);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int BFS(int startNum, int endNum) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(startNum);
		cnt[startNum]++;
		visit[startNum] = true;
		int move = -1;
		
		while(!queue.isEmpty()){
			
			startNum = queue.poll();
			move = cnt[startNum];
			if(startNum == endNum) {
				return move-1;
			}

			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 10; j++) {
					if( !( i == 3 && j == 0 ) ) {
						int changeNum = swap(startNum,i,j);
						if( !isPrime[changeNum] && !visit[changeNum] ) {
							queue.add(changeNum);
							visit[changeNum] = true;
							cnt[changeNum] = cnt[startNum]+1;
						}
					}
				}
			}
		}
		return -1;
	}

	private static int swap(int startNum, int place, int swapNum) {
		
		int removeNum = (int) ( startNum % Math.pow(10, place+1) );
		removeNum -= ( removeNum % Math.pow(10, place) );
		int changeNum = startNum - removeNum;
		changeNum += ( swapNum * Math.pow(10, place) );
		return changeNum;
		
		
	}
}
