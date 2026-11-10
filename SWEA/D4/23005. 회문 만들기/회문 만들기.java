import java.util.*;
import java.io.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            int length = str.length();
            int left = 0;
            int right = length - 1;
            int count = 0;
            while(left < right) {
                char leftC = str.charAt(left);
                char rightC = str.charAt(right);
                if(leftC == rightC){
                    left +=1;
                    right -=1;
                } else if (leftC == 'x') {
                    left += 1;
                    count += 1;
                } else if( rightC == 'x') {
                    right -= 1;
                    count += 1;
                } else {
                    count = -1;
                    break;
                }
            }
            System.out.println(count);
        }
    }
}