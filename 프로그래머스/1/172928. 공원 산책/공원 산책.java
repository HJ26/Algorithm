import java.io.*;
import java.util.*;

class Solution {
    
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static Map<String, Integer> direction = new HashMap<>();
    
    public int[] solution(String[] park, String[] routes) {
        
        int R = park.length;
        int C = park[0].length();
        
        // 문자별 방향 저장
        direction.put("N",0);    // 상  -> 가로 -1, 세로 0
        direction.put("S",1);    // 하  -> 가로 +1, 세로 0 
        direction.put("W",2);    // 좌  -> 가로 0 세로 -1
        direction.put("E",3);    // 우 -> 가로 0 세로 +1 
        
        
        // 시작점 찾기
        int r = 0, c = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(park[i].charAt(j) == 'S'){
                    r = i;
                    c = j;
                }
            }
        }
        

        // 진행
        StringTokenizer st;
        int M = routes.length;  // 이동 횟수
        route: for(int t = 0; t < M; t++){
            // 방향과 이동 거리 나누기
            st = new StringTokenizer(routes[t]);
            int dir = direction.get(st.nextToken());
            int nMove = Integer.parseInt(st.nextToken());
            
            // nr, nc 에 현재 위치 대입
            int nr = r; 
            int nc = c;
            
            // 이동 방향으로 횟수 만큼 이동
            for(int m = 0; m < nMove; m++){
                // 다음 위치
                nr += dr[dir];  
                nc += dc[dir];
                // 가는 도중에 공원 밖으로 나가거나 장애물 있으면 안움직이고 다음꺼로 넘어가기
                if( nr < 0 || nr >= R || nc < 0 || nc >= C ) continue route;
                if(park[nr].charAt(nc) == 'X') continue route;
            }
            
            // 중간에 안멈추고 이동 완료했으면 현재 위치 업데이트
            r = nr;
            c = nc;
        }
        
        return new int[] { r, c };
    }
}