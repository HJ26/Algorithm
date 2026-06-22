import java.io.*;
import java.util.*;
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
            int[] jobs = new int[n], costs = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) jobs[i] = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) costs[i] = Integer.parseInt(st.nextToken());
            
            PriorityQueue<Persuasion> pq = new PriorityQueue<>();
            Map<Integer, PriorityQueue<Persuasion>> map = new HashMap<>();
            for(int i=0; i<n; i++) {
                PriorityQueue<Persuasion> value = map.get(jobs[i]);
                if(value == null) {
                    value = new PriorityQueue<>();
                    map.put(jobs[i], value);
                }
                value.add(new Persuasion(i, costs[i]));
                
                if(value.size() > 1) {
                    pq.add(value.remove());
                }
            }
            
            int size = map.size();
            long cost = 0;
            while(k > size) {
                cost += pq.remove().cost;
                size++;
            }
            sb.append('#').append(tc).append(' ').append(cost).append('\n');
        }
        
        System.out.print(sb);
    }

    static class Persuasion implements Comparable<Persuasion> {
        int index, cost;
        
        public Persuasion(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Persuasion o) {
            return this.cost - o.cost;
        }
    }
}