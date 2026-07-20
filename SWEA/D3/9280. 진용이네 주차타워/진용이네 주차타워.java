import java.util.*;
import java.io.*;

public class Solution {
	static boolean[] park;
	static int n;
	static Queue<Integer> waitQue;
	static HashMap<Integer, Integer> map;
	static int income;
	static int[] w;
	static int[] car;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			park = new boolean[n+1];
			w = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				w[i] = Integer.parseInt(br.readLine());
			}
			
			car = new int[m+1];
			for(int i=1; i<=m; i++) {
				car[i] = Integer.parseInt(br.readLine());
			}
			
			map = new HashMap<>();
			income = 0;
			waitQue = new ArrayDeque<>();

			for(int i=0; i<m*2; i++) {
				int curCar = Integer.parseInt(br.readLine());
				int carNum = Math.abs(curCar);
				
				if(curCar > 0) {
					waitQue.offer(carNum);
					parking();
				}
				else if (curCar <0) {
					park[map.get(carNum)] = false;
					map.remove(carNum); 
                    
					if(!waitQue.isEmpty()) {
						parking();
					}
				}
				
			}
			sb.append("#"+t+" "+income+"\n");	
		}
		System.out.print(sb);
	}
	

	public static void parking() {
		int parkNum = canPark();

		if(parkNum != -1) { 
			int carN = waitQue.poll();
			
			park[parkNum] = true;
			map.put(carN, parkNum);
			income += (w[parkNum]*car[carN]);
		}
	}
	
	public static int canPark() {
		for(int i=1; i<=n; i++) {
			if(!park[i]) {
				return i;
			}
		}
		return -1;
	}
}