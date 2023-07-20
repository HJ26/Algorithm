
import java.util.Scanner;

public class Main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] person = new int[n];
        for(int i = 0; i < n; i++) {
        	person[i] = i+1;
        }
        
        int[] result = new int[n];
        int count = 0;
        int index = k-1;
        
        while ( count < n ){
            
            result[count] = person[index];
            
            // index change
            for(int i = index; i < n-count-1; i++) {
            	person[i] = person[i+1];
            }
            
            index += (k-1);
            while ( index >= (n-count-1) ) {
            	if( n-count-1 == 0) break;
            	index -= (n-count-1);
            }
            count++;
            
       }
        
        System.out.print("<");
        for(int i = 0; i < n; i++){
            if ( i != n-1 )
                System.out.print(result[i]+", ");
            else
                System.out.println(result[i]+">");
        }
    }
}