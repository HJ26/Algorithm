import java.util.*;

class Solution {
    
    // 사방 탐색
    static int[] dr = { -1, 1, 0, 0}, dc = { 0, 0, 1, -1};
    
    // 장소 정보를 저장할 클래스
    static class Place{
        int r;
        int c;
        int time;
        
        public Place(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    
    
    public int solution(String[] maps) {
        
        int answer = -1;
        
        // 기본 정보를 저장할 변수 선언
        int R = maps.length;
        int C = maps[0].length();
        
        // 시작지점 찾기
        Place start = new Place(0,0,0);
        
        findStartPlace: 
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(maps[r].charAt(c) == 'S'){
                    start.r = r;
                    start.c = c;
                    start.time = 0;
                    break findStartPlace;
                }
            }
        }
        
        // 방문처리할 배열
        // 레버 찾기 전후로 별도의 방문처리 필요 -> 2개로 나눠서 관리
        boolean[][][] visit = new boolean[R][C][2];
        int isLever = 0;
        
        // 시작지점을 기준으로 사방탐색하면서 레버, 종료지점 찾기
        Queue<Place> que = new LinkedList();
        que.add(new Place(start.r, start.c, start.time));
        visit[start.r][start.c][isLever] = true;
        
        findMinRoute: 
        while(!que.isEmpty()){
            
            // 현재 위치
            Place cur = que.poll();
            int curR = cur.r;
            int curC = cur.c;
            int nextTime = cur.time + 1;
            
            // 사방 탐색
            for(int dir = 0; dir < 4; dir++){
                
                // 다음 위치
                int nextR = curR + dr[dir];
                int nextC = curC + dc[dir];
                
                // 지도를 넘어갔거나 이미 확인한 곳이면 넘기기
                if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || visit[nextR][nextC][isLever]) continue;
                
                // 탐색할 곳이므로 반문처리
                visit[nextR][nextC][isLever] = true;
                
                // 위치 이름
                char placeName = maps[nextR].charAt(nextC);
                if(isLever == 0){        // 레버를 찾는 경우
                    
                    if( placeName == 'L') {                 // 레버를 찾은경우 
                        isLever = 1;                                // 찾았다고 표시하고
                        while(!que.isEmpty()) que.poll();           // 큐 비우고
                        que.add(new Place(nextR, nextC, nextTime)); // 현재 지점 추가하고
                        break;                                      // 사방 탐색 종료
                    } else if( placeName == 'X') continue;  // 벽인 경우 다음 방향 탐색
                    else{                                   // 나머지의 경우 ( 통로이거나 출구 )
                        que.add(new Place(nextR, nextC, nextTime)); // 다음 탐색 지점으로 큐에 저장
                        visit[nextR][nextC][isLever] = true;        // 방문 처리
                    }
                    
                }else{                  // 탈출구를 찾는 경우
                    
                    if( placeName == 'E'){  // 탈출구를 찾은 경우
                        answer = nextTime;      // 최소 시간 갱신하고
                        break findMinRoute;     // 경로 탐색 종료
                    } else if( placeName == 'X') continue;  // 벽인 경우 다음 방향 탐색
                    else{                   // 나머지의 경우 ( 통로이거나 레버 )
                        que.add(new Place(nextR, nextC, nextTime)); // 다음 탐색 지점으로 큐에 저장
                        visit[nextR][nextC][isLever] = true;        // 방문 처리
                    }
                }
            }
            
        }
        return answer;
    }
}