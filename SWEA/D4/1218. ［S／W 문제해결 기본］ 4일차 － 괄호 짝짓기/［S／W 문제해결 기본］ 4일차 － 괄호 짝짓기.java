import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        map.put('<','>');
        
        Stack<Character> stack;
        int answer;
        for(int tc = 1; tc <= 10; tc++){
            br.readLine();
            answer = 1;
            
            stack = new Stack<>();
            String str = br.readLine();
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(map.containsKey(ch)) stack.push(map.get(ch));
                else if( stack.isEmpty() || stack.peek() != ch){
                    answer = 0;
                    break;
                }else stack.pop();
            }
            sb.append("#"+tc+" " + answer + "\n");
        }
        System.out.println(sb);
    }
}