import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, minDiff;
	static int[][ ] map;
	static int[] tmp,tmp2;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 팀을 나눕니다
		minDiff = Integer.MAX_VALUE;
		tmp = new int[N/2];
		tmp2 = new int[N/2];
		visit = new boolean[N];
		divideTeam(0,0);

		System.out.println(minDiff);
	}
	
	// 팀의 조합을 구하는 함수
	private static void divideTeam(int idx, int sidx) {
	
		// idx = 사람번호
		// sidx = 뽑은 사람 수
		
		if(sidx == N/2) {
			for(int i = 0, idx2 = 0; i < N; i++) {
				if(!visit[i]) {
					tmp2[idx2++] = i;
				}
			}
			findMin();
			return;
		}
		
		if(idx == N) return;
		tmp[sidx] = idx;
		visit[idx] = true;
		divideTeam(idx+1, sidx+1);
		visit[idx] = false;
		divideTeam(idx+1, sidx);
		
	}

	private static void findMin() {
		
		int team1 = 0;
		int team2 = 0;
		for(int i : tmp) {
			for(int j : tmp) {
				team1 += map[i][j];
			}
		}
		
		for(int i : tmp2) {
			for(int j : tmp2) {
				team2 += map[i][j];
			}
		}
		
		minDiff = Math.min(minDiff, Math.abs(team1-team2)); 
		
	}
	
	
}
