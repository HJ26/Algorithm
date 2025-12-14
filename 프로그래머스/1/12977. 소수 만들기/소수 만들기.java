import java.util.*;

class Solution {
    static boolean[] isPrime;
    static int answer = 0, max = 3001;
    public int solution(int[] nums) {

        // 소수 배열 만들기
        isPrime = new boolean[max];
        Arrays.fill(isPrime, true);
        for(int i = 2; i < max; i++){
            for(int j = i*2; j < max; j += i){
                isPrime[j] = false;
            }
        }
        
        // 숫자 조합 만들기
        combi(0,0,0,nums);
        return answer;
    }
    
    private void combi(int idx, int sidx, int sum, int[] nums){
        if(sidx == 3){
            if(isPrime[sum]) answer++;
            return;
        }
        
        if(idx == nums.length) return;
        
        combi(idx+1, sidx+1, sum + nums[idx], nums);
        combi(idx+1, sidx, sum, nums);
        
    } 
}