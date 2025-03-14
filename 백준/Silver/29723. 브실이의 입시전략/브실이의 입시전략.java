import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            map.put(subject,score);
        }

        int ans = 0;
        for (int i = 0; i < K; i++) {
            String colSubject = br.readLine();
            ans += map.get(colSubject);
            map.remove(colSubject);
            M--;
        }

        int ansOfMax = ans;
        int ansOfMin = ans;
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);

        int j = N - K - 1;
        
        for (int i = 0; i < M; i++, j--) {
            ansOfMax += list.get(j);
            ansOfMin += list.get(i);
        }

        sb.append(ansOfMin).append(" ").append(ansOfMax);
        System.out.println(sb);
    }
}