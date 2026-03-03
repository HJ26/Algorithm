import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
 
        StringTokenizer st;
        int country, student, score;
        Node node;
        Node []nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
 
            country = Integer.parseInt(st.nextToken());
            student = Integer.parseInt(st.nextToken());
            score = Integer.parseInt(st.nextToken());
 
            node = new Node(country, student, score);
            nodes[i] = node;
        }
 
        Arrays.sort(nodes, (o1, o2) -> o2.score - o1.score );
 
        int cnt = 0;
        int []count = new int[n+1];
        for (int i = 0; i < n; i++) {
            if(count[nodes[i].country] == 2){
                continue;
            }else if(cnt == 3){
                break;
            }
 
            sb.append(nodes[i].country).append(" ").append(nodes[i].student).append("\n");
            count[nodes[i].country]++;
            cnt++;
        }
 
        System.out.println( sb.substring(0, sb.length() -1).toString() );
    }
    public static class Node{
        int country;
        int student;
        int score;
 
        public Node(int country, int student, int score) {
            this.country = country;
            this.student = student;
            this.score = score;
        }
    }
}