import java.util.*;
import java.io.*;

class Main {
        static int r,c;
        static char [][] map;
        static char [][] result;
        static int [] dx = {-1,-1,-1,0,0,1,1,1};
        static int [] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(r==0 && c== 0) break;

            map = new char[r][c];
            result = new char[r][c];

            for(int i=0;i<r;i++){
                map[i] = br.readLine().toCharArray();
            }

            for(int j=0;j<r;j++){
                for(int k=0;k<c;k++){
                    if(map[j][k]=='*'){
                        result[j][k] = '*';
                    }else
                        find(j, k);
                }
            }

            for(int i=0;i<r;i++){
                sb.append(new String(result[i])).append("\n");
            }
        }
        
        System.out.print(sb);
    }

    public static void find(int x, int y){
        int count = 0;

        for(int i=0;i<8;i++){
            int xx = x+dx[i];
            int yy = y+dy[i];

            if(xx>=0 && xx<r && yy>=0 && yy<c && map[xx][yy]=='*'){
                count++;
            }
        }

        result[x][y] = (char)(count+'0');
    }
}