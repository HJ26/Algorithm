import java.util.*;
import java.io.*;

class Solution {
    
    static char arr[];
    static int N;
    static String rslt;
    
	public static void main(String args[]) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
        StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            arr = s.toCharArray();  
           
            N = Integer.parseInt(st.nextToken());
            
            rslt = ""; 
            dfs(0,0);
            System.out.println("#"+tc+" "+ rslt);
        }
	}
    
    public static void dfs(int depth, int cnt){
        
       if(cnt==N){
            String cur = new String(arr); 
            if (cur.compareTo(rslt) > 0) {  
                rslt = cur;  
            }
           return;
       }
        
       for(int i=depth; i<arr.length;i++){
           for(int j =i+1; j<arr.length; j++){
               change(i, j);
               dfs(i, cnt+1);
               change(i,j);
           }
       }
    }
    
    private static void change(int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}