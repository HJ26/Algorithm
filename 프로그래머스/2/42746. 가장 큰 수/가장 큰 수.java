import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        
        // 문자열로 만들어 합친 후 크기 비교하여 정렬
        Arrays.sort(nums, new Comparator<Integer>(){
            
            @Override
            public int compare(Integer o1, Integer o2){
                
                int tmp1 = Integer.parseInt(Integer.toString(o1) + Integer.toString(o2));
                int tmp2 = Integer.parseInt(Integer.toString(o2) + Integer.toString(o1));
                return tmp2 - tmp1;
                
            }
        });
        
        // 모든 수가 0 인 경우 처리
        if(nums[0] == 0) return "0";
        
        for(int i : nums){
            answer += i;
        }
        
        return answer;
    }
}