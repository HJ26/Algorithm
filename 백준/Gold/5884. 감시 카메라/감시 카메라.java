import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Map<Integer,Integer> xMap = new HashMap<Integer, Integer>();
		Map<Integer,Integer> yMap = new HashMap<Integer, Integer>();
		int[][] cows = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 소 위치 좌표 저장
			cows[i][0] = x;
			cows[i][1] = y;
			
			// 좌표 빈도수 확인을 위해 map에 저장
			if(!xMap.containsKey(x)) xMap.put(x,1);
			else xMap.put(x, xMap.get(x)+1);
			
			if(!yMap.containsKey(y)) yMap.put(y,1);
			else yMap.put(y, yMap.get(y)+1);
			
		}
		
		// 카메라가 순회할 죄표를 저장할 배열
		int[][] cameras = new int[3][2];
        
		for(int i =0; i < 3; i++) {
			
			// 최대 빈도 좌표 저장
			Map.Entry<Integer, Integer> xMaxEntry = null;
			Map.Entry<Integer, Integer> yMaxEntry = null;

			// Map 순회하면서 최대값 찾기
			// x좌표
			for(Map.Entry<Integer, Integer> ent : xMap.entrySet()) {
				if(xMaxEntry == null || ent.getValue().compareTo(xMaxEntry.getValue()) > 0) 
					xMaxEntry = ent;
			}
			
			// y좌표
			for(Map.Entry<Integer, Integer> ent : yMap.entrySet()) {
				if(yMaxEntry == null || ent.getValue().compareTo(yMaxEntry.getValue()) > 0) 
					yMaxEntry = ent;
			}
			
			// 두 좌표 중 빈도가 큰 값 저장
			if(xMaxEntry.getValue() >= yMaxEntry.getValue()){
                cameras[i][0] = 0;
                cameras[i][1] = xMaxEntry.getKey();
                xMap.remove(cameras[i][1], xMaxEntry.getValue());
            }
            else{
            	cameras[i][0] = 1;
            	cameras[i][1] = yMaxEntry.getKey();
                yMap.remove(cameras[i][1], yMaxEntry.getValue());
            }
		}
		
		boolean rslt = true;
		
		// 카메라 경로 확인하면서 체크
        for(int i=0; i<N; i++)
            if(cows[i][ cameras[0][0] ] != cameras[0][1] && cows[i][ cameras[1][0] ] != cameras[1][1] && cows[i][ cameras[2][0] ] != cameras[2][1]){
                rslt = false;
                break;
            }
        	
        System.out.println(rslt? 1 : 0);
	}
}
