import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        map.put("red", 0);
        map.put("orange", 1);
        map.put("yellow", 2);
        map.put("green", 3);
        map.put("blue", 4);
        map.put("purple", 5);
		
        while(TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken(), b = st.nextToken();
            if(a.equals(b)) {
                sb.append('E').append('\n');
                continue;
            }
            int aIndex = map.get(a), bIndex = map.get(b);
			
            if((bIndex+1)%6 == aIndex || bIndex == (aIndex+1)%6) sb.append('A');
            else if(bIndex == (aIndex+3)%6 || (bIndex+3)%6 == aIndex) sb.append('C');
            else sb.append('X');
            sb.append('\n');
        }
        System.out.print(sb);
    }
}