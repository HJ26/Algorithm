import java.io.*;
import java.util.*;

public class Main {

	static int N, C, size;
	static int[] house, select, diff;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 데이터 받기
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		house = new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house);
        
		int left = 1;
		int right = house[N-1]-house[0]+1;
		int maxDist = Integer.MIN_VALUE;
		
		while( left < right) {
			
			int mid = (left + right) / 2;
			
			int nWifi = 1;
			int idx = 0;
			for(int i = 1; i < N; i++) {
				if(house[i]-house[idx] >= mid) {
					nWifi++;
					idx = i;
				}
			}
			
			if(nWifi >= C) {
				maxDist = Math.max(maxDist, mid);
				left = mid+1;
			}
			else right = mid;
			
		}
		
		bw.write(Integer.toString(maxDist));
		bw.close();
		br.close();
	}
}