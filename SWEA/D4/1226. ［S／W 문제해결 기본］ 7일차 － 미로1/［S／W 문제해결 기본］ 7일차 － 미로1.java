import java.util.*;
import java.io.*;

class Solution{
    
    static int size=0;
    static int ans;
    static char[][] map;
    static Point start, end;
    static int[] dx={-1, 1, 0, 0}, dy={0, 0, -1, 1};
    static class Point {
            int x;
            int y;
            public Point(int x, int y){
                this.x=x;
                this.y=y;
            }
	}
    public static void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=10;
        for(int tc = 1; tc <= T; tc++){
            br.readLine();
            map=new char[16][16];
            for(int i=0; i<16; i++){
                String s=br.readLine();
                for(int j=0; j<16; j++){
                    map[i][j]=s.charAt(j);
                    if(map[i][j]=='2'){
                        start=new Point(i, j);
                    }
                }
            }
            ans=0;
            getRes(start);
            System.out.println("#"+tc+" "+ans);
        }
    }
    
    public static void getRes(Point cur){
        if(map[cur.x][cur.y]=='3'){
            ans=1;
            return;
        }
        
        map[cur.x][cur.y]='1';
        
        for(int i=0; i<4; i++){
            int cx=cur.x+dx[i];
            int cy=cur.y+dy[i];
            if(ans==1){
                return;
            }
            if(cx>=0 && cx<16 && cy>=0 && cy<16 && map[cx][cy]!='1'){
                getRes(new Point(cx, cy));
            }
        }
    }

}