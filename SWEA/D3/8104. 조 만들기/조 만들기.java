import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();


        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();
            int K = sc.nextInt();

            int sum = 0;
            for(int i=1; i<=N; i++){

                if(i % 2 == 0){
                    sum += (i * K);
                }else{
                    sum += ((i-1) * K) + 1;
                }
            }
            
             sb.append("#"+tc+" ");
            for(int i=0; i<K; i++){
                if(N % 2 == 0){
                    sb.append(sum).append(" ");
                }else{
                    sb.append(sum + i).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
