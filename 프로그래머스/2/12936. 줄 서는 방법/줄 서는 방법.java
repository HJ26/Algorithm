import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> arr = new ArrayList<>();
        
        // 총 경우의 수 = n!
        long total = 1;
        for(int i = 1; i <= n; i++){
            arr.add(i);
            total *= i;
        }
        
        // 배열 인덱스는 0부터 시작 -> 찾아야할 번호 -1
        k--;
        
        int idx = 0;
        while(idx < n){
            // 전체 경우의 수 / 숫자의 수
            total /= ( n - idx );
            // 해당 인덱스의 값의 숫자 가져오기
            answer[idx++] = arr.remove((int) (k/total));
            // 다음 찾아야 할 번호
            k %= total;
        }
        
        return answer;
    }
}