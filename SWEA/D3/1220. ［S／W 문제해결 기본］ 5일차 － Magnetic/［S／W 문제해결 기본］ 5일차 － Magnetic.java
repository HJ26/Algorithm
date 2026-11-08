import java.util.Scanner;

class Solution {


    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = 10;
        int result;
        for (int tc = 1; tc <= T; tc++) {

            result = 0;
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<N; i++){
                int red = 0;
                int blue =0;
                
                for(int j=0; j<N; j++){
                    if(arr[j][i] ==1){
                        red =1;
                        blue = 0;
                    }else if(arr[j][i] ==2){
                        blue =1;
                    }

                    if(blue == 1 && red ==1) {
                        result++; 
                        blue = red = 0;
                    }
                }
            }

            sb.append("#"+tc+" "+result+"\n");
        }

        System.out.println(sb);
    }

}