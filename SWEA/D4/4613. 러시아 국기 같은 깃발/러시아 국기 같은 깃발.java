import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    static int[] W;
    static int[] B;
    static int[] R;
    static int N;
    static int M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        
        for(int T=0; T<tc; T++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            W = new int[N];
            B = new int[N];
            R = new int[N];
            
            for(int i=0; i<N; i++) {    
                String flagRow = br.readLine();
                for(int j=0; j<M; j++) {
                    int word = flagRow.charAt(j);
                    if( word == 'W') W[i]++;
                    else if(word == 'B') B[i]++;
                    else R[i]++;
                }
            }
            
            int sum = 0;
            for(int i=1; i<=N-2; i++) { 
                for(int j=i; j<N-1; j++) {  
                    int wCnt = 0;
                    int bCnt = 0;
                    int rCnt = 0;
                    
                    for(int k=0; k<i; k++) wCnt += W[k]; 
                    for(int k=i; k<=j; k++) bCnt += B[k]; 
                    for(int k=j+1; k<N; k++) rCnt += R[k];
                    
                    sum = Math.max(sum, wCnt+bCnt+rCnt); 
                }
            }
            sum = N * M - sum;
            sb.append("#" + (T+1) + " " + sum + "\n");
        }
        System.out.println(sb);
    }
}