import java.io.*;

class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
		for(int i=1; i<=T; i++) {
			String[] str = br.readLine().split(" ");
			int D = Integer.parseInt(str[0]);
			int intL = Integer.parseInt(str[1]);
			float floatL =(float)intL/100;
			int N = Integer.parseInt(str[2]);
			System.out.println("#"+i+" "+recul(D,floatL,N));
		}
	}
    
	private static int recul(int d, float l, int n) {
		if(n==1) {
			return (int) (d*(1+(n-1)*(l/100)));
		}
		else {
			int val = Math.round(d*(1+(n-1)*l));
			return val + recul(d,l,n-1);
		}
	}
}
