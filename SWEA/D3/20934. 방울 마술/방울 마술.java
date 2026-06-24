import java.io.*;
import java.util.*;
  
 
public class Solution{
 
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());  
 
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
             
            String S = st.nextToken(); 
            int k = Integer.parseInt(st.nextToken());  
             
            int currentPosition = S.indexOf("o");  
            int newPosition = calculateNewPosition(currentPosition, k);  
             
            sb.append("#").append(tc).append(" ").append(newPosition).append("\n");
        }
 
        System.out.println(sb.toString());
    }
 
   
    private static int calculateNewPosition(int currentPosition, int moves) {
        if (moves == 0)  return currentPosition; 
 
        if (currentPosition == 0 || currentPosition == 2) {
            return (moves % 2 == 0) ? 0 : 1;
        } else if (currentPosition == 1) {
            return (moves % 2 == 0) ? 1 : 0;
        }
 
        return currentPosition;
    }
}