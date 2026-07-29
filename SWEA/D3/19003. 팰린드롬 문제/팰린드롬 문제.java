import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int TC = Integer.parseInt(br.readLine());

        for(int tc =1; tc<=TC; tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            String Pal[] = new String[N];
            String notPal[] = new String[N];
            int p = 0;
            int np = 0;
            
            for(int i=0; i<N; i++){
                String input = br.readLine();
                if(!isPal(input)){
                    notPal[np] = input;
                    np++;
                }
                else{
                    Pal[p] = input;
                    p++;
                }
            }

            int count = 0;
            
            boolean visited[] = new boolean[100];
            for(int i=0; i<np-1; i++){
                for(int j=i+1; j<np; j++){
                    if(checkPal(notPal[i],notPal[j]) && !visited[i] && !visited[j]){
                        visited[i] = true;
                        visited[j] = true;
                        count += 2*M;
                    }
                }
            }

            visited = new boolean[100];
            boolean flag = true;
            for(int i=0; i<p-1; i++){
                for(int j=i+1; j<p; j++){
                    if(Pal[i] == Pal[j] && !visited[i] && !visited[j]){
                        sb.append("진입\n");
                        visited[i] = true;
                        visited[j] = true;
                        count += 2*M;
                        flag = false;
                    }
                }
            }

            if(flag && p!=0) count += M;

            sb.append("#" + tc + " "+ count + "\n");
        }
		System.out.println(sb);
    }

    public static boolean isPal(String input){
        int mid = input.length()/2;
        for(int i=0; i<mid; i++){
            if(input.charAt(i) != input.charAt(input.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkPal(String input, String input2){
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) != input2.charAt(input.length()-1-i)){
                return false;
            }
        }
        return true;
    }

}