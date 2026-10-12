import java.io.*;
 
public class Solution {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            String t = br.readLine();
            int result = 0;
            int tResult = 0;
            boolean flag = true;
            arr = new int[5];
            
            for(int j=0;j<t.length();j++) {
                switch (t.charAt(j)) {
                case 'c':
                    if(tResult!=0) {
                        tResult--;
                        result--;
                    }
                    result++;
                    arr[0]++;
                    break;
                case 'r':
                    arr[0]--; arr[1]++;
                    if(arr[0]<0) {
                        flag = false;
                        result = -1;
                    }
                    break;
                case 'o':
                    arr[1]--; arr[2]++;
                    if(arr[1]<0) {
                        flag = false;
                        result = -1;
                    }
                    break;
                case 'a':
                    arr[2]--; arr[3]++;
                    if(arr[2]<0) {
                        flag = false;
                        result = -1;
                    }
                    break;
                case 'k':
                    arr[3]--; tResult++;
                    if(arr[3]<0) {
                        flag = false;
                        result = -1;
                    }
                    break;
                }
                if(!flag) break;
            }
            
            for(int j=0;j<5;j++) {
                if(arr[j]!=0) {
                    result=-1;
                    break;
                }
            }
            System.out.println("#"+tc+" "+result);
        }
    }
}