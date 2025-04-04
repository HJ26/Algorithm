import java.io.*;
import java.util.*;

public class Main {
	
	public static int N;
	public static int[] arr;
	public static int[] prefixSum;
	public static long answer = 0;
    public static void main(String[] args) throws IOException{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
        N = Integer.parseInt(st.nextToken());
    	arr = new int[N];
    	prefixSum = new int[N+1];
    	st = new StringTokenizer(br.readLine());
    	
    	int sumValue = 0;
    	for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	
        	sumValue += arr[i];
        	prefixSum[i + 1] = sumValue;
    	}
    	

    	for(int i=0;i<N;i++) {
    		int standard = arr[i];
    		int calculatedSum = prefixSum[N] - prefixSum[i+1];
    		answer += standard * calculatedSum;
    	}
    	
    	System.out.println(answer);
    	
    }
}