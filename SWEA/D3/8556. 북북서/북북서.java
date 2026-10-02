import java.util.ArrayList;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=Integer.parseInt(sc.nextLine());
	
		StringBuffer sb = new StringBuffer();
		
		for(int tc = 1; tc <= T; tc++){
			String s = sc.nextLine();
			ArrayList<Integer> al = new ArrayList<>();
			
			if(s.endsWith("north")) {
				s=s.substring(0,s.length()-5);
				al.add(0);
			}else{
				s=s.substring(0,s.length()-4);
				al.add(90);
			}
		
			int count=1;
			int sum =0;
			
			while(!s.equals("")) {
				if(s.endsWith("north")) {
					s=s.substring(0,s.length()-5);
					al.add(-90);
				}else{
					s=s.substring(0,s.length()-4);
					al.add(90);
				}
				count*=2;
			}
			
			String result = "";

			for(int i=0; i<al.size(); i++) {
				sum += al.get(i)*(Math.pow(2,al.size()-1-i));
			}
			
			while(sum%2==0 && count!=1) {
				sum/=2;
				count/=2;
			}
			
			if(count==1) {
				result = Integer.toString(sum);
			}else {
				result = Integer.toString(sum)+"/"+Integer.toString(count);
			}
			
			sb.append("#"+tc+" "+result+'\n');

		}
		System.out.print(sb);
	}
}