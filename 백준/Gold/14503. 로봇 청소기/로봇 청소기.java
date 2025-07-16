import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, nClean = 0;
    static int[] dr = { -1,  0, 1, 0 }, dc = { 0, -1, 0, 1 }; // 북 서 남 동
    static int[][] room;
    static boolean[][] visited;

    static class Point{
        int r;
        int c;
        int dir;

        public Point(int r, int c, int dir){
            this.r = r;
            this.c = c;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    ", dir=" + dir +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());

        Point p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        p.dir = ( p.dir % 2 == 0 ? p.dir : (p.dir == 1 ?  3 : 1)) ;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[p.r][p.c] = true;
        nClean++;

        cleaning(p);
        System.out.println(nClean);

    }

    private static void cleaning(Point p){

        boolean flag = false;
        for(int dir = 1; dir <= 4; dir++){
            int nDir = ( p.dir + dir ) % 4;

            int nr = p.r + dr[nDir];
            int nc = p.c + dc[nDir];
            if(!check(nr,nc)) continue;
            if(room[nr][nc] == 0) {
                visited[nr][nc] = true;
                nClean++;
                cleaning(new Point(nr, nc, nDir));
                return;
            }

        }

        // 청소 할 곳이 없었던 경우
        int nDir = ( p.dir + 2 ) % 4;
        int nr = p.r + dr[nDir];
        int nc = p.c + dc[nDir];
        if(room[nr][nc] == 1) return;
        cleaning(new Point(nr, nc, p.dir));

    }

    private static boolean check(int nr, int nc){
        return nr < N && nr >= 0 && nc < M && nc >= 0 && !visited[nr][nc];
    }
}
