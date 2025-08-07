import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visit = new boolean[26];
    static String BASIC = "antatica";
    static int N,K, max = 0;
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for(int i = 0; i < N; i++) words[i] = br.readLine();

        // 기본 단어 방문처리
        // a n t i c
        for(int i = 0; i < BASIC.length(); i++){
            visit[BASIC.charAt(i)-'a'] = true;
        }
        K -= 5;

        if(K < 0) {
            System.out.println(0);
            return;
        }

        study(0 ,0);

        System.out.println(max);
    }

    private static void study(int idx, int sidx) {
        if(idx == K){
            findWords();
            return;
        }

        if(sidx == 26) return;

        if(!visit[sidx]){
            visit[sidx] = true;
            study(idx+1, sidx+1);
            visit[sidx] = false;
            study(idx, sidx+1);
        }else{
            study(idx, sidx+1);
        }

    }

    private static void findWords() {
        int sum = 0;
        Loop:
        for(String word : words){
            for(int i = 4; i < word.length()-4; i++){
                if(!visit[word.charAt(i)-'a']) continue Loop;
            }
            sum++;
        }

        max = Math.max(max, sum);
    }
}
