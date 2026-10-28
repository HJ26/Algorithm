import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            if(a>c){
                System.out.println("#"+tc+" "+(a-c));
            }else if(b<c){
                System.out.println("#"+tc+" -1");
            }else{
                System.out.println("#"+tc+" 0");
            }
		}
	}
}