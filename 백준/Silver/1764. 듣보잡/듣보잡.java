import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) map.put(br.readLine(), 1);
        
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name,0) +  1);
            if (map.get(name) == 2) list.add(name);
        }
        
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        sb.append(list.size() + "\n");
        for (String s : list) {
            sb.append(s + "\n");
        }
        
        System.out.print(sb);
    }
}