import java.util.*;

public class Solution {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int tc = 1; tc <= T; tc++){
            int numsSize = sc.nextInt();
            String nums = sc.next();
            
            int index = 0;
            while (index < nums.length() - 1) {
                if (nums.charAt(index) == nums.charAt(index + 1)) {
                    nums = nums.substring(0, index) + nums.substring(index + 2);
                    
                    if (index > 0) {
                        index--;
                    }
                } else {
                    index++;
                }
            }

            System.out.println("#" + tc + " " + nums);
		}
	}
}