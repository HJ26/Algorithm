import java.io.*;
import java.util.*;

public class Main {
	static int N, M, minDist;
	static int[] selectShop;
	static int[][] map, dist;
	static List<Shop> totalShop, house;
	
	static class Shop{
		int r, c;
		public Shop() {}
		public Shop(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 정보를 저장할 변수 초기화
		map = new int[N][N];
		totalShop = new ArrayList();
		house = new ArrayList();
		selectShop = new int[M];

		
		// 지도 정보 받기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) totalShop.add(new Shop(i,j));
				else if(map[i][j] == 1) house.add(new Shop(i,j));
			}
		}
		
		// 각 가게와 집까지의 거리 다 구해놓기
		dist = new int[totalShop.size()][house.size()];
		for(int i = 0; i < totalShop.size(); i++) {
			for(int j = 0; j < house.size(); j++) {
				dist[i][j] = Math.abs(totalShop.get(i).r - house.get(j).r) + Math.abs(totalShop.get(i).c - house.get(j).c);
			}
		}
		
		// 최대 M개까지 고르기
		minDist = Integer.MAX_VALUE;
		for(int max = 1; max <= M; max++) {
			combi(0,0,max);
		}
		
		bw.write(minDist+"");
		bw.close();
		br.close();
	}

	private static void combi(int idx, int sidx, int max) {
		
		// M개 다 뽑았으면 거리계산해!
		if(sidx == max) {
			calDist(max);
			return;
		}
		
		// 전체 가게 다 봤으면 종료
		if(idx == totalShop.size()) return;
		
		// 조합 뽑기
		selectShop[sidx] = idx;
		combi(idx+1, sidx+1, max);	// 뽑기
		combi(idx+1, sidx, max);		// 안뽑기
	}

	private static void calDist(int max) {
		
		int total = 0;
		// 각 집을 돌면서 선택된 가게와의 거리 중 가장 최소값을 더해주기
		for(int i = 0; i < house.size(); i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < max; j++) {
				min = Math.min(min, dist[selectShop[j]][i]);
			}
			total += min;
		}
		minDist = Math.min(minDist, total);
		
	}
}
