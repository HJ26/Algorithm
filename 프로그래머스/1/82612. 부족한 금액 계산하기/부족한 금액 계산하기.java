class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;

        for(int i = price; count > 0; i += price, count--){
            answer -= i;
        }
        
        return answer < 0 ? answer * -1 : 0;
    }
}