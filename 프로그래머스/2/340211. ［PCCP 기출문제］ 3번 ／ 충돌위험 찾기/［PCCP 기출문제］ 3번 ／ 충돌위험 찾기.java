import java.util.*;

class Solution {
    
    static class Robot{
         
        int r, c, id, routeId;
        
        public Robot(int r, int c, int id, int routeId) {
            this.r = r;
            this.c = c;
            this.id = id;
            this.routeId = routeId;
        }
        
        @Override
		public String toString() {
			return "Robot [r=" + r + ", c=" + c + ", id=" + id + ", routeId=" + routeId + "]";
		}
    }
    
    static class Point{
        int r, c;
        
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        
        int answer = 0;
        
        int nPoint = points.length;
        int nRobot = routes.length;
        int nRoute = routes[0].length;
        int[][] visit = new int[101][101]; // 현재 위치에 로봇 유무를 저장할 배열
        boolean[] isArrive = new boolean[nRobot];
        
        // 현재 위치 저장하기
        // 다음 경로 아이디 저장하기
        Queue<Robot> que = new LinkedList<>();
        for(int i = 0; i < nRobot; i++){
            
            int pointTmp = routes[i][0]-1;  // 인덱스로 활용 --> 1 빼기
            int rTmp = points[pointTmp][0];
            int cTmp = points[pointTmp][1]-1;
            
            que.add(new Robot(rTmp, cTmp, i, 0));
        }
        
        
        // 큐가 빌때까지 반복
        int moveId = 1;
        int minusMoveId = moveId * (-1);
        int maxId = nRobot - 1;
        while(!que.isEmpty()){

            Robot curPoint = que.poll();                        // 현재위치
            
            int arrivalId = routes[curPoint.id][curPoint.routeId] - 1;
            Point arrivalPoint = new Point(points[arrivalId][0],points[arrivalId][1]);      // 도착위치
                      
            int nextR = curPoint.r, nextC = curPoint.c, nextRouteId = curPoint.routeId;
            if(curPoint.r != arrivalPoint.r){           // r좌표가 도착지와 다른 경우 이동
                if(curPoint.r > arrivalPoint.r) nextR = curPoint.r - 1;
                else nextR = curPoint.r + 1;
            }else{                                      // r좌표가 같은 경우 c 좌표 이동
                if(curPoint.c > arrivalPoint.c) nextC = curPoint.c - 1;
                else nextC = curPoint.c + 1;
            }
            
            // 도착한경우 경로 업데이트
            if(nextR == arrivalPoint.r && nextC == arrivalPoint.c) {
                nextRouteId = curPoint.routeId + 1;
            }
            
            // 방문한 적 있으면 음수로 바꾸고 충돌 위험 횟수 추가
            if(visit[nextR][nextC] == moveId) {
                answer++;
                visit[nextR][nextC] = minusMoveId;
            } else if( visit[nextR][nextC] != minusMoveId ){    // 방문한 적이 아예 없으면 현재 도착했다고 알려주기
                visit[nextR][nextC] = moveId;
            }
                
            // 마지막 로봇까지 이동했으면 이동 여부 초기화
            if(curPoint.id == maxId) {
                moveId++;
                minusMoveId--;
            }
            
            // 도착지 도착했으면 끝 아니면 경로에 추가
            if(nextRouteId < nRoute) que.add(new Robot(nextR, nextC, curPoint.id, nextRouteId));
            else {  // 도착지에 도착한경우
                
                // 도착 처리 후 남은 로봇 중 제일 높은 숫자 로봇 찾기
                isArrive[curPoint.id] = true;
                if(curPoint.id == maxId){
                    maxId = -1;
                    for(int i = 0; i < nRobot; i++) {
                    if(!isArrive[i]) maxId = Math.max(maxId, i);
                }
                }
            }
        }
        
        
        return answer;
    }
}