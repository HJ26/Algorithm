import java.util.*;

class Solution{
	public static void main(String args[]) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <=10; tc++){
			sc.nextInt();
			String find = sc.next();
			String s = sc.next();
			int answer=0;
			
			for(int i=0; i<=s.length()-find.length(); i++){
				String sub = s.substring(i,i+find.length());
				if(sub.equals(find)) answer++;
			}
			
			System.out.printf("#%d %d\n",tc,answer);
		}
	}
}