import java.util.*;

class Solution {
    
    static Point startR, startB;
    static int N, M;
    static int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };
    static boolean[][][][] visit;   // 두 점의 도착 조합을 저장할 배열
    
    static class Point{
        int r;
        int c;
        int nTurn;
        boolean[][] visit;
        boolean isArrive = false;   // 도착점에 도착한 점인지 확인
        
        
        public Point(int r, int c, int nTurn, boolean[][] visit){
            this.r = r;
            this.c = c;
            this.nTurn = nTurn;
            this.visit = visit;
        }
        
        public Point(int r, int c, int nTurn, boolean isArrive, boolean[][] visit){
            this.r = r;
            this.c = c;
            this.nTurn = nTurn;
            this.isArrive = isArrive;
            this.visit = visit;
        }
        
        public Point(Point p){
            this.r = p.r;
            this.c = p.c;
            this.nTurn = p.nTurn;
            this.isArrive = p.isArrive;
            this.visit = new boolean[N][M];
            for(int i = 0; i < N; i++) this.visit[i] = Arrays.copyOf(p.visit[i], M);
        }
    }
    
    public int solution(int[][] maze) {
        int answer = 0;
        
        N = maze.length;
        M = maze[0].length;
        visit = new boolean[N][M][N][M];
        
        // 두 점의 시작 지점 찾기
        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(maze[r][c] == 1) {
                    startR = new Point(r, c, 0, new boolean[N][M]);
                    startR.visit[r][c] = true;
                }else if(maze[r][c] == 2) {
                    startB = new Point(r, c, 0, new boolean[N][M]);
                    startB.visit[r][c] = true;
                }
            }
        }
        
        // 턴 시작
        answer = turn(maze);
        
        return answer;
    }
    
    
    private int turn(int[][] maze){
        
        // 두 점의 위치를 저장할 큐
        Queue<Point[]> que = new LinkedList<>();
        
        // 시작 지점 저장
        visit[startB.r][startB.c][startR.r][startR.c] = true;
        que.add(new Point[] {new Point(startB), new Point(startR)});
        
        while(!que.isEmpty()){
            Point[] cur = que.poll();
            Point curB = cur[0];
            Point curR = cur[1];
            
            // 두 점이 모두 도착한 상태면 종료
            if(curR.isArrive && curB.isArrive) return Math.max(curR.nTurn, curB.nTurn);
            
            List<Point> reds = new ArrayList<>();
            List<Point> blues = new ArrayList<>();
            
            // 두 점이 갈 수 있는 위치 저장
            blues = findPlace(0, new Point(curB), new Point(curR), maze);
            reds = findPlace(1, new Point(curR), new Point(curB), maze);
            
            // 갈 수 있는 점의 조합 찾아서 큐에 저장
            for(Point b : blues){
                for(Point r : reds){
                    
                    // 두 점이 모두 같은 곳으로 가려는 경우
                    // 두 점이 교차 이동 하려는 경우
                    // 이미 간 적이 있는 점인 경우
                    // 큐에 넣지 않고 넘기기
                    if(b.r == r.r && b.c == r.c) continue;
                    if(b.r == curR.r && b.c == curR.c && r.r == curB.r && r.c == curB.c ) continue;
                    if(visit[b.r][b.c][r.r][r.c]) continue;
                    
                    // 도착 가능한 점의 조합인 경우 방문 처리하고 큐에 넣기
                    visit[b.r][b.c][r.r][r.c] = true;
                    
                    que.add(new Point[] { new Point(b) , new Point(r) });
                }
            }
        }
        return 0;
    }
    
    // 갈 수 있는 점 찾기
    private List<Point> findPlace(int idx, Point curP, Point partP, int[][] maze){
        List<Point> points = new ArrayList<>();
        
        // 이미 도착지에 도착한 점이면
        // 턴만 증가시키고 현재 점 저장 후 종료
        if(curP.isArrive){
            points.add(new Point(curP.r, curP.c, curP.nTurn+1, curP.isArrive, curP.visit));
            return points;
        }
        
        // 4방향 탐색
        for(int dir = 0; dir < 4; dir++){
            
            int nr = curP.r + dr[dir];
            int nc = curP.c + dc[dir];
            
            // 맵 밖이거나 벽이면 이동 불가능 ( 넘기기 )
            if(nr >= N || nr < 0 || nc >= M || nc < 0 ) continue;
            if(maze[nr][nc] == 5 || curP.visit[nr][nc]) continue;
            
            curP.visit[nr][nc] = true;
            // 해당하는 점의 도착지점이면 도착 여부 업데이트 후 리스트에 넣기
            // ( 각 점의 도착 숫자 , 인덱스 ) ==> Red : ( 3, 1 ), Blue : ( 4, 0 )
            if(maze[nr][nc] + idx == 4){
                points.add(new Point(nr, nc, curP.nTurn + 1, true, curP.visit));   
            }else{
                points.add(new Point(nr, nc, curP.nTurn + 1, curP.isArrive, curP.visit));   
            }
            curP.visit[nr][nc] = false;
        }
        
        return points;
    }

}