import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        List<BigInteger> answer = new ArrayList<BigInteger>();
        
        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            StringBuilder sb = new StringBuilder();

            for(int j =0; j<temp.length(); j++){
                char a = temp.charAt(j);

                if(Character.isDigit(a)){
                    sb.append(a);
                }else {
                    if(sb.length()>0){
                        answer.add(new BigInteger(sb.toString()));
                        sb = new StringBuilder();
                    }
                }
            }

            if(sb.length()>0){
                answer.add(new BigInteger(sb.toString()));
            }
        }
        
        Collections.sort(answer);
        for(BigInteger num : answer){
            System.out.println(num);
        }
    }
}