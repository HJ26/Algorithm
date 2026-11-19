import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int tc = 1; tc <= T; tc++) {
            int sum = 0;
            for(int j=0; j<10; j++) { 
                int num = sc.nextInt();
                if(num%2 != 0)
                    sum = sum + num;
            }
            System.out.println("#"+tc+" "+sum);
        }
    }
}
