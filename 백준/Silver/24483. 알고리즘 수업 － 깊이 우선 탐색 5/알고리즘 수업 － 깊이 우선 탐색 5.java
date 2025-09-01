import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, M, start, cnt = 0;
    static int[] visit, arr;
    static ArrayList<Integer>[] graph;
    static long rslt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visit = new int[N+1];
        arr = new int[N+1];

        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int i = 1; i <= N; i++) Collections.sort(graph[i]);
        Arrays.fill(visit, -1);
        visit[start] = 0;
        
        dfs(start, 0);
        System.out.println(rslt);
    }
    
    private static void dfs(int start, int depth) {
        visit[start] = depth;
        arr[start] = ++cnt;
        rslt += (long) arr[start] * depth;
        for(int i : graph[start]){
            if(visit[i] != -1) continue;
            dfs(i, depth + 1);
        }
    }
}
