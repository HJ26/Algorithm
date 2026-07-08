import java.io.*;
import java.util.*;

public class Solution {
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=T; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " "); 
            int max = 0;
            int min = 1000000;
            
            while(st.hasMoreTokens()) {
                int sum = 0;
                String num = st.nextToken(); // num 에 첫번째 토큰 값을 넣음
                for(int j=0; j<num.length(); j++) { // num길이 만큼 반복함
                    sum = sum + (num.charAt(j)-'0'); // num.charAt(j) - '0' :: char 형을 int 형으로 변환해서 더함
                }
                
                if( sum > max)
                    max = sum;
                
                if( sum < min)
                    min = sum;
            }
            
            sb.append("#" + i + " " + max + " " + min + "\n");
        }
        System.out.println(sb);
    }
}