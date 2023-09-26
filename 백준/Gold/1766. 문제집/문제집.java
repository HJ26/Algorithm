import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer>[] height = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            height[i] = new ArrayList();
        }
        
        int[] edges  = new int[N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1; 
            int end = Integer.parseInt(st.nextToken())-1; 
            height[start].add(end);
            edges[end]++;
        }
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            if(edges[i] == 0) que.add(i);
        }
        
        while(!que.isEmpty()) {
        	int curr = que.poll();
        	sb.append(curr+1).append(" ");
        	for(int next : height[curr]) {
        		edges[next]--;
        		if(edges[next] == 0) que.add(next);
        	}
        }
        
        bw.write(sb.toString());
        bw.close();
        br.close();
        
    }
}