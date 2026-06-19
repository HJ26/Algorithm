import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            System.out.println("#" + tc + " " + (isPalindromeOfPalindrome(str) ? "YES" : "NO"));
        }
    }
    
    public static boolean isPalindromeOfPalindrome(String str) {
        int N = str.length();
                
        if (!isPalindrome(str, 0, N - 1))  return false;
        
        if (!isPalindrome(str, 0, (N-1)/2 - 1)) return false;
        
        if (!isPalindrome(str, N - (N-1)/2, N - 1)) return false;
        
        return true;
    }
    
    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;           
            start++;
            end--;
        }
        return true;
    }
}