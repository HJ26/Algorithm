import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Solution{
    static int[][] arr;
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
		for(int tc = 1; tc <= T; tc++){
            sb.append("#"+tc+" ");
            int N = Integer.parseInt(br.readLine());
            int start, end;
            int[] corridors = new int[200];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                start = (Integer.parseInt(st.nextToken()) -1) /2;
                end = (Integer.parseInt(st.nextToken()) -1) /2;
                
                if(start > end){
                    int temp = start;
                    start = end;
                    end = temp;
                }
                
                for(int j = start; j <= end; j++){
                    corridors[j] ++;
                }
            }
            
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 200; i++){
                max = Math.max(max, corridors[i]);
            }
            
            sb.append(max+"\n");
		}
        System.out.print(sb);
	}

}