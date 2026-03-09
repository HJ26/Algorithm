import java.io.*;
import java.util.*;

public class Main {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String str1 = st.nextToken();
        String str2 = st.nextToken();

        result = countEight(str1, str2);

        System.out.println(result);
    }
    
    static int countEight(String str1, String str2){
        if(str1.length() == str2.length()){
            int count = 0;
            for(int i = 0; i < str2.length(); i++){
                if(str1.charAt(i) == str2.charAt(i)){
                    if(str1.charAt(i) == '8') count++;
                }else{
                    break;
                }
            }
            return count;
        } else return 0;
    }
}