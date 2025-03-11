import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new TreeSet<>();
        for(int i = 0; i < 2; i++)		//아빠 새 몸통, 꼬리 색
            set.add(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2; i++)		//엄마 새 몸통, 꼬리 색
            set.add(st.nextToken());
 
        StringBuilder sb = new StringBuilder();
        for(String body : set){
            for(String tail : set)
                sb.append(body+" "+tail+"\n");
        }
 
        System.out.print(sb);
    }
}