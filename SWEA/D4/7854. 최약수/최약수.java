import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] one = {1, 2, 5};
		int[] two = {20, 25, 50, 100};
		int[] three = {100, 125, 200, 250, 500};
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int cnt = 0;
			String s = sc.next();
			int n = s.length();
			
			if(n == 1) {
				int num = Integer.parseInt(s);
				for(int i = 0; i < one.length; i++) {
					if(num >= one[i]) cnt++;
					else break;
				}
			}
			
			else if(n == 2) {
				cnt += 3;
				int num = Integer.parseInt(s);
				for(int i = 0; i < two.length; i++) {
					if(num >= two[i]) cnt++;
					else break;
				}
			}
			
			else {
				for(int i = 0; i < n-1; i++) {
					if(i == 0) cnt += 3;
					else if(i == 1) cnt += 4;
					else cnt += 5;
				}
				String tmp = s.substring(0, 3);
				int num = Integer.parseInt(tmp);
				for(int i = 0; i < three.length; i++) {
					if(num >= three[i]) cnt++;
					else break;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}