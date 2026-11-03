import java.util.*;

class Solution {


    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        String result;
        for (int tc = 1; tc <= T; tc++) {
            result = "Impossible";
            boolean possible = true;

            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int lastTime = arr[N - 1];
            int bread = 0;
            int idx = 0;
            
            if(arr[0] == 0){
                possible = false;
            }else{
            for (int i = 1; i <= lastTime; i++) {
                if (i % M == 0) bread += K;
                if (idx < N) {
                    if (i == arr[idx]) {
                        idx++;
                        if (bread > 0) bread--;
                        else {
                            possible = false;
                            break;
                        }
                    }
                }
            }
            }

            if (possible) result = "Possible";
            sb.append("#"+tc+" "+result + "\n");
        }

        System.out.println(sb);
    }

}