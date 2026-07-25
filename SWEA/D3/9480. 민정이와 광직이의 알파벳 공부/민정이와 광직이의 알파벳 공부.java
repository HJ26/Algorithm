import java.io.*;
import java.util.*;

class Solution{
    static int cnt = 0;
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            
            cnt = 0;

            int N = Integer.parseInt(br.readLine());

            List<String> list = new ArrayList<>();
            boolean alphabet[][] = new boolean[N][26];

            for(int i=0; i<N; i++){
                String word = br.readLine();
                list.add(word);
                for(char j='a'; j<='z'; j++){
                    if(word.contains(String.valueOf(j))) {
                        alphabet[i][j-'a'] = true;
                    }
                }
            }

            for(int i=1; i<=N; i++) solve(0, 0, i, N, alphabet, new boolean[N]);
            
            sb.append("#"+tc+" "+cnt+"\n");
        }
        System.out.println(sb);
    }
    
    private static void solve(int i, int size, int max, int N, boolean alphabet[][], boolean check[]){
        if(size >= max){
            if(isPossible(N, alphabet, check)) cnt++;
            return;
        }
        if(i >= N) return;
        
        check[i] = true;
        solve(i+1, size+1, max, N, alphabet, check);
        check[i] = false;
        solve(i+1, size, max, N, alphabet, check);

    }
    private static boolean isPossible(int N, boolean alphabet[][], boolean check[]){
        for(char a = 'a'; a <= 'z'; a++){
            boolean isContains =  false;
            for(int i=0; i<N; i++){
                if(alphabet[i][a-'a'] && check[i]){
                    isContains = true;
                    break;
                }
            }
            if(!isContains) return false;
            
        }
        return true;
    }
}