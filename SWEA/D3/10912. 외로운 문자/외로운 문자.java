import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++) {
            char[] s = br.readLine().toCharArray();
            int[] check = new int['z'+1];
            StringBuilder ans = new StringBuilder();
            for(int i = 0; i < s.length; i++) {
                check[s[i]]++;
            }
            for(int i = 'a'; i <= 'z'; i++) {
                if(check[i]%2 != 0)
                    ans.append(Character.toString((char)i));    
            }
            if(ans.length() == 0)
                sb.append("#" + tc + " Good\n" );
            else
                sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);
    }
}