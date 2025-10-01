import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, E;
    static List<Edge>[] edges;
    static int[] vertex = new int[2];
    static boolean[] flag = { true, true };

    static class Edge{
        int to;
        int dist;

        Edge(int to, int dist){
            this.to = to;
            this.dist = dist;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            edges[i] = new ArrayList<Edge>();
        }

        // 간선 정보 입력
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }

        // 무조건 지나야 하는 정점
        st = new StringTokenizer(br.readLine());
        vertex[0] = Integer.parseInt(st.nextToken());
        vertex[1] = Integer.parseInt(st.nextToken());

        // 최단경로 찾기

        int dist1 = djk(1,vertex[0], 0) + djk(vertex[0], vertex[1], 0) + djk(vertex[1], N, 0);
        int dist2 = djk(1,vertex[1], 1) + djk(vertex[1], vertex[0], 1) + djk(vertex[0], N, 1);

        if(!flag[0]) dist1 = Integer.MAX_VALUE;
        if(!flag[1]) dist2 = Integer.MAX_VALUE;

        int answer = Math.min(dist1, dist2);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static int djk(int start, int end, int flagIdx){

        if(!flag[flagIdx]) return -1;
        if(start == end) return 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });

        boolean[] visit = new boolean[N+1];
        visit[start] = true;
        for(Edge e : edges[start]){
            pq.add(new Edge(e.to, e.dist));
        }

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(cur.to == end){
                return cur.dist;
            }
            for(Edge e : edges[cur.to]){
                if(visit[e.to]) continue;
                pq.add(new Edge(e.to, cur.dist + e.dist));
            }
            visit[cur.to] = true;
        }

        flag[flagIdx] = false;
        return -1;
    }
}
