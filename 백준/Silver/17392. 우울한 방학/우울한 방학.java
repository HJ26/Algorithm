import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int []arr= new int[1001];
    static int []arr2= new int[1001];
    
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int val = 0;
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            val += arr[i]+1;
        }
        
        int left = m - val;
        if(m<=0){
            System.out.println(0);
            return ;
        }
        
        while(true) {
            for (int i = 0; i < n + 1; i++) {
                if (left <= 0)
                    break;
                arr2[i]++;
                left--;
            }
            if(left<=0)
                break;
        }
        
        int ans =0;
        for(int i=0;i<n+1;i++) {
          for(int j=1;j<=arr2[i];j++)
          {
              ans += j*j;
          }
        }
        System.out.println(ans);
    }
}