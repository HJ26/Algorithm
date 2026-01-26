import java.util.*;
import java.io.*;
 
public class Main {
    static int M, K, T;
    static int[] D = new int[51];
    static double prob[] = new double[51];
    static double ans;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        M = Integer.parseInt(br.readLine());    // M : 색 종류
        
        // 색깔 별 조약돌 개수 저장
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < M ; i++) {
            D[i] = Integer.parseInt(st.nextToken());
            T += D[i];  // 조약돌 개수 더하기
        }
 
        // 한 색깔 조약돌만 뽑을 확률을 색깔별로 모두 계산
        K = Integer.parseInt(br.readLine());    // K : 선택 조약돌 개수
        ans = 0.0;
        
        for(int i = 0 ; i < M ; i++) {
            if(D[i] >= K) {
                prob[i] = 1.0;
                
                for(int k = 0 ; k < K ; k++) {
                    prob[i] *= (double) (D[i] - k) / (T - k);
                }
            }
            ans += prob[i];
        }
        
        System.out.println(ans);

    }
}
