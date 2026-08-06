import java.io.*;
import java.util.*;


public class Solution {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc-- > 0) {
            int length = Integer.parseInt(br.readLine());
            String word = br.readLine();
            char[] stack = new char[length];
            int top = 0;
            
            for (int i = 0; i < length; i++) {
                stack[top++] = word.charAt(i);
                if (top >= 3 && stack[top-3] == 'f' && stack[top-2] == 'o' && stack[top-1] == 'x') {
                    top -= 3;
                }
            }
            
            sb.append(top+"\n");
        }
        System.out.print(sb);
    }
}