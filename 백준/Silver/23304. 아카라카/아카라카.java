import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static boolean Palin(String str) {
		int strLen = str.length();
		for(int i = 0; i < strLen/2; i++) {
			if( ! (str.charAt(i)==str.charAt(strLen-1-i)) ) {
				return false;
			}
		}
		return true;
	}
    
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String word = br.readLine();
    	int wordLen = word.length();
    	boolean isAkarakaPalin = false;
    	if(Palin(word)) {
    		isAkarakaPalin = true;
    		int i = wordLen/2;
    		while( i > 0 ) {
    			if( !Palin(word.substring(0,i)) ) {
    				isAkarakaPalin = false;
    				break;
    			}
    			i /= 2;
    		}
		}
    	if(isAkarakaPalin ) {
    		System.out.println("AKARAKA");
    	}else {
    		System.out.println("IPSELENTI");
    	}
    } 
} 