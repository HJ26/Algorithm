import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String[] str = br.readLine().split(" ");
			double p = Double.parseDouble(str[0]);
			double q = Double.parseDouble(str[1]);
			String result = "YES";
			
			double s1 = (1-p)*q;
			double s2 = p*(1-q)*q;
			if(s1 >= s2) result = "NO";
			
			sb.append("#"+tc+" "+result+"\n");
		}
        System.out.println(sb);

	}

}