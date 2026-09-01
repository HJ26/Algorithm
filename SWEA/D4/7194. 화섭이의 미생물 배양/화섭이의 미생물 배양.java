import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
    	Scanner sc= new Scanner(System.in);
    	int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(b == 1) {
                int tmp = t-s;
                if(tmp%a==0) {
                    System.out.println("#"+tc+" "+(t-s)/a);
                }else {
                    System.out.println("#"+tc+" -1");
                }
                continue;
            }
            int goHome = 0;
            while(s!=t) {
                if(t%b==0) {
                    if(t/b < s) {
                        goHome++;
                        t -= a;
                    }else {
                        goHome++;
                        t /= b;
                    }
                }else {
                    goHome++;
                    t -= a;
                }
                if(s > t) {
                    goHome = -1;
                    break;
                }
            }
            System.out.println("#"+tc+" "+goHome);
        }
    }

}