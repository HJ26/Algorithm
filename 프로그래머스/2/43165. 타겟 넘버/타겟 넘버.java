class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public void dfs(int[] numbers, int idx, int sum, int target){
        
        int sumTmp = sum + numbers[idx];
        int minusTmp = sum - numbers[idx];
        
        if(idx == numbers.length-1 ){
            if( sumTmp == target || minusTmp == target) answer++;
            return;
        }
        
        dfs(numbers, idx+1, sumTmp, target);
        dfs(numbers, idx+1, minusTmp, target);
    }
}