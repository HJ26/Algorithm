import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            String[] num = {"0001101", "0011001", "0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
            HashMap<String, Integer> hm = new HashMap<>();
            for(int i = 0; i<10; i++) {
                hm.put(num[i], i);
            }

            String[] str = new String[N];
            for(int i = 0; i<N; i++) {
                str[i] = sc.next();
            }

            String s = "";
            for(int i = 0; i<N; i++) {
                if(str[i].contains("1")) {
                    int idx = str[i].lastIndexOf("1");
                    s = str[i].substring(idx-55,idx+1);
                }
            }

            int odd = 0;
            int even = 0;
            for(int i = 0; i<8; i++) {
                String code = s.substring(i*7,i*7+7);
                if(i%2 == 0) {
                    odd += hm.get(code);
                }
                else {
                    even += hm.get(code);
                }
            }

            int result = 0;
            if((odd * 3 + even) % 10 == 0) {
                result = odd + even;
            }

            sb.append("#" + tc + " " + result + "\n");
        }
        System.out.println(sb);
    }
}