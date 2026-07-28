import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
		for(int tc = 1; tc <= T; tc++){
            long N = Long.parseLong(br.readLine());
            long result = 0;
            
            if(isPrime(N)){
                result = N - 1;
            }else{
                    for(int i = (int)Math.sqrt(N); i >= 1; i--){
                        if(N % i == 0){
                            result = (i + N / i) -2;
                            break;
                        }
                    }
            }        
            sb.append("#" + tc + " " + result + "\n");
        }
        System.out.println(sb);
    }
    
    private static boolean isPrime(long N){
        for(int i = 2; i <= Math.sqrt(N); i++){
            if(N % i == 0){
                return false;
            }
        }
        return true;
    }
}
