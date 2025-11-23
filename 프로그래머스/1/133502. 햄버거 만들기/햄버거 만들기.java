import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
       int answer = 0;
		List<Integer> arr = new ArrayList<>();
		
		for(int i :ingredient) {
			arr.add(i);
			while(arr.size() >= 4) {
				int n = arr.size();
				if(!(arr.get(n-1) == 1
					&& arr.get(n-2)==3
					&& arr.get(n-3) ==2
					&& arr.get(n-4)==1)) break;
				for(int j=0; j<4; j++) {
					arr.remove(arr.size() -1);
				}
				answer++;
			}
		}
        return answer;
    }
}