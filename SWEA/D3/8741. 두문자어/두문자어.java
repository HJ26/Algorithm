import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        for(int tc = 1; tc <= T; tc++){
            String str=sc.nextLine();
            String str1[]=str.split(" ");
            String ans="";
            
            for(int i=0;i<str1.length;i++) ans+=str1[i].substring(0,1);
            String ans2=ans.toUpperCase();
            System.out.println("#"+tc+" "+ans2);
        }
    }
}