import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    static int N;
    static String[] arr;
    
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
		int T;
		T = Integer.parseInt(br.readLine());
      
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++){ 
            
			N = Integer.parseInt(br.readLine()); 
			arr = new String[N];
    	  
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine();
			}
			
			int starti=N-1;
			int startj= N-1; 
			int endi =0;
			int endj =0;
			
			for(int i=0; i<N; i++) {
				if(!arr[i].contains("#")) continue;
				for(int j=0; j<N; j++) {
					if(arr[i].charAt(j) == '#') {
						starti=Math.min(starti,i);
						startj=Math.min(startj,j);
						endi=Math.max(endi,i);
						endj=Math.max(endj,j);
					}
				}
			}
            
			boolean check = true;
            for(int i = starti; i <= endi; i++) {
                for(int j = startj; j <= endj; j++) {
                    if(arr[i].charAt(j)=='.') {
                    	check=false;
                    	break;
                    }
                }
            }
            
            String result = (check && endi-starti == endj-startj) ? "yes":"no";
			sb.append("#"+tc+" "+result).append('\n');
		}
		System.out.print(sb);
	}
}