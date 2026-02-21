import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        int sLen = s.length();
        int tLen = t.length();

        int lcm = LCM(sLen, tLen);

        StringBuilder sbs = new StringBuilder();
        StringBuilder sbt = new StringBuilder();

        for(int i=0; i<lcm/sLen; i++) sbs.append(s);
        
        for(int i=0; i<lcm/tLen; i++) sbt.append(t);
        

        if(sbs.toString().equals(sbt.toString())) System.out.println(1);
        else System.out.println(0);

    }

    public static int GCD(int a,int b){
        while(b>0){
            int tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }

    public static int LCM(int a,int b){
        return a*b/GCD(a,b);
    }
}