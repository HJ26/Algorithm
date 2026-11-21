import java.util.*;
import java.io.*;

public class Solution {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc<=T; tc++) {
            sb.append("#"+tc+" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parent = new int[N+1];
            rank = new int[N+1];

            for (int i = 0; i < N+1; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (command == 1) {
                    sb.append(find(a) == find(b) ? 1 : 0);
                }
                else {
                    union(a, b);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int find(int a) {
        if (parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            }
            else {
                parent[rootB] = rootA;
                if (rank[rootA] == rank[rootB]) {
                    rank[rootA]++;
                }
            }
        }
    }
}