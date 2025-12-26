class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int tmp = 0;
        int origin = x;
        
        // 각 자리수의 합 구하기
        while(x > 0){
            tmp += x%10;
            x /= 10;
        }
        
        return origin%tmp == 0;
    }
}