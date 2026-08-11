import java.io.*;
import java.util.*;

public class Solution {

    static int ans, x, y, dir;
    static int dx[]={1, 0, -1, 0};
    static int dy[]={0, 1, 0, -1};
    static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            str = br.readLine();

            ans = 0;
            solve();
            if(ans==-1) {
                sb.append("#" + tc + " " + "oo" + "\n");
            }else {
                sb.append("#" + tc + " " + ans + "\n");
            }
        }
        System.out.println(sb);
    }

    static void solve() {
        
        x=y=dir=0;
        
        for(int i=0;i<4;i++) {
            int sDir = dir;
            command();
            if(x==0 && y==0) {
                return; 
            }
            if(dir==sDir) {
                ans = -1;
                return;
            }
        }
    }

    static void command() {
        for(int i=0;i<str.length();i++) {
            char now = str.charAt(i);
            if(now=='S') {
                x = x + dx[dir];
                y = y + dy[dir];
                ans = Math.max(ans, calR(x, y));
            }else if(now=='L') {
                dir = (dir+1)%4;
            }else if(now=='R') {
                dir = (dir+3)%4;
            }
        }
    }

    static int calR(int x, int y) {
        return (int) (Math.pow(x, 2) + Math.pow(y, 2));
    }

}