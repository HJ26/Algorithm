import java.io.*;

public class Solution {
     public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        for(int i = 0; i < Integer.parseInt(s[1]); i++){
            for(int j = 0; j < Integer.parseInt(s[0]); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }    
}