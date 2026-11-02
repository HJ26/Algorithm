import java.io.*;
import java.util.*;

// # 크루스칼
public class Solution {

    public static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int cost;

        Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            Edge[] edges = new Edge[e];
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                edges[i] = new Edge(a, b, c);
            }

            Arrays.sort(edges);

            parent = new int[v+1];
            for (int i = 0; i <= v; i++) {
                parent[i] = i;
            }

            int count = 0;
            long answer = 0;
            for (Edge edge : edges) {
                int rootA = find(edge.a);
                int rootB = find(edge.b);

                if (rootA != rootB) {
                    count++;
                    answer += edge.cost;
                    union(rootA, rootB);

                    if (count == v-1) break;
                }
            }

            sb.append("#"+tc+" "+answer+"\n");
        }
        System.out.print(sb);
    }

    public static int find(int a) {
        if (parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int rootA, int rootB) {
        parent[rootA] = rootB;
    }
}