import java.io.*;
import java.util.*;

public class Main {

    static int[][] garden;   // 정원 정보
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static int N,M,G,R, max;
    static int[] green, red;

    static List<int[]> place;   // 배양액을 뿌릴 수 있는 위치
    static boolean[] isGreen;   // 초록 배양액을 뿌린 곳
    
    // 배양액 위치를 저장할 클래스
    static class Place{
        int r;
        int c;
        int time;
        int color;

        public Place(int r, int c, int time, int color){
            this.r = r;
            this.c = c;
            this.time = time;
            this.color = color;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        max = 0;
        garden = new int[N][M];
        place = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                garden[i][j] = Integer.parseInt(st.nextToken());
                if (garden[i][j] == 2) place.add(new int[]{i, j});
            }
        }
            
        green = new int[G];
        red = new int[R];
        isGreen = new boolean[place.size()];
        choiceGreen(0,0);

        System.out.println(max);

        

    }
    
    // 초록색 배양액을 뿌릴 토양 선택
    private static void choiceGreen(int idx, int sidx){
        
        // 다 선택했으면 빨간색 위치 뽑기
        if(sidx == G){
            choiceRed(0,0);
            return;
        }
        if(idx == place.size()) return;

        green[sidx] = idx;
        isGreen[idx] = true;    // 뽑은 위치 저장
        choiceGreen(idx+1,sidx+1);
        isGreen[idx] = false;   // 안뽑았을 때 상태 업데이트
        choiceGreen(idx+1, sidx);
    }
    
    // 빨간 배양액을 뿌릴 위치 뽑기
    private static void choiceRed(int idx, int sidx){

        if(sidx == R){
            // 확산 시작
            start();
            return;
        }
        if(idx == place.size()) return;

        // 초록색 배양약을 뿌리지 않은 위치일때마 뽑기
        if(!isGreen[idx]) {
            red[sidx] = idx;
            choiceRed(idx+1,sidx+1);
        }
        choiceRed(idx+1,sidx);
    }

    // 확산
    private static void start(){
        
        Queue<Place> que = new LinkedList<>();
        int[][][] visit = new int[N][M][2];     // 배양액 별로 도착한 시간 정보 저장힐 베열
        int nFlower = 0;                        // 만들어진 꽃의 개수
        
        // 초기 배양액 정보 저장
        for(int idx : green){
            int[] tmp = place.get(idx);
            que.add(new Place(tmp[0], tmp[1], 1, 0));
            visit[tmp[0]][tmp[1]][0] = 1;
        }

        for(int idx : red){
            int[] tmp = place.get(idx);
            que.add(new Place(tmp[0], tmp[1], 1, 1));
            visit[tmp[0]][tmp[1]][1] = 1;
        }

        while(!que.isEmpty()){
            
            Place cur = que.poll();
            
            // 현재 위치의 배양액 정보가 저장했을때의 상태와 동일한지 확인
            // 확산 가능 -> 큐에 저장 -> 이후 다른 배양액으로 꽃이 핌 -> 확산 불가능 : 이와 같은 상황 대비
            if(visit[cur.r][cur.c][cur.color] != cur.time) continue;
            
            // 사방으로 확산
            for(int dir = 0; dir < 4; dir++){
                int nr = cur.r+dr[dir];
                int nc = cur.c+dc[dir];

                // 정원의 호수이거나 정원 밖이면 넘기기
                if( nr < 0 || nr >= N || nc < 0 || nc >= M || garden[nr][nc] == 0 ) continue;

                // 이미 꽃이 핀 경우
                if(visit[nr][nc][0] == -1) continue;

                //  내 색이 이미 전파되어있는 경우
                if(visit[nr][nc][cur.color] != 0) continue;

                // 다른 색이 이미 전파한 경우
                int other = cur.color == 0 ? 1 : 0;
                if(visit[nr][nc][other] != 0){
                    if(visit[nr][nc][other] == cur.time+1) {
                        nFlower++;
                        visit[nr][nc][0] = -1;
                        visit[nr][nc][1] = -1;
                    }
                    continue;
                }
                
                // 전파 정보 저장
                visit[nr][nc][cur.color] = cur.time + 1;
                que.add(new Place(nr, nc, cur.time+1, cur.color));

            }
        }

        max = Math.max(max, nFlower);
    }
}
