import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 1;
            for(int i = 1; i <= n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                char value = st.nextToken().charAt(0);
                boolean digit = Character.isDigit(value);

                if (st.hasMoreTokens()){
                    if(digit){
                        answer = 0;
                    }
                }
                
                else{
                    if(!digit){
                        answer = 0;
                    }
                }
            }
            sb.append("#" + tc + " " + answer + "\n");
        }
        System.out.println(sb);
    }
}