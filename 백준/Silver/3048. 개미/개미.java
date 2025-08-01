import java.util.*;
import java.io.*;

public class Main {
    static class Ant {
        char value;
        int direction;

        public Ant(char value, int direction){
            this.value = value;
            this.direction = direction;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n1 = Integer.parseInt(st.nextToken()); 
        int n2 = Integer.parseInt(st.nextToken());
        Ant[] group1 = new Ant[n1+1]; 
        Ant[] group2 = new Ant[n2+1];

        String input = br.readLine();
        for(int i=n1-1; i>=0; i--){
            group1[i] = new Ant(input.charAt(n1-i-1), 1);
        }

        input = br.readLine();
        for(int i=0; i<n2; i++){
            group2[i] = new Ant(input.charAt(i), -1);
        }

        Ant[] start = new Ant[n1+n2];
        
        for(int i=0; i<n1; i++) start[i] = group1[i];
        for(int i=n1; i<n1+n2; i++) start[i] = group2[i-n1];
        
        int T = Integer.parseInt(br.readLine());
        Ant[] end = start;
        for(int i=0; i<T; i++){
            Ant[] cur = end.clone();
            for(int j=0; j<n1+n2-1; j++){
                if(cur[j].direction == 1 && cur[j+1].direction == -1){
                    Ant tmp = cur[j];
                    end[j] = cur[j+1];
                    end[j+1] = tmp;
                }
                else
                    continue;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n1+n2; i++)
            sb.append(end[i].value);

        System.out.println(sb.toString());
    }
}