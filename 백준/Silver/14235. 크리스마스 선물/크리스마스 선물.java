import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N;
    
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
       return o2 - o1;
    });
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        N = atoi(br.readLine());
 
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = atoi(st.nextToken());
 
            if(a == 0){
                if(pq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
            else{
                for (int j = 0; j < a; j++) {
                    pq.offer(atoi(st.nextToken()));
                }
            }
        }
 
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
