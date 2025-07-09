class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int delivery = 0;
        int pickup = 0;
        
        for(int idx = n-1; idx >= 0; idx--){
            delivery += deliveries[idx];
            pickup += pickups[idx];
            
            while(delivery > 0 || pickup > 0 ){
                delivery -= cap;
                pickup -= cap;
                answer += (idx + 1) * 2;
            }
        }
        
        return answer;
    }
}