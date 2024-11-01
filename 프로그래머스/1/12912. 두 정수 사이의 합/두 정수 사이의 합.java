class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int tmp = Math.max(a, b);
        a = Math.min(a, b);
        b = tmp;
        for(int i = a; i <= b; i++){
            answer += i;
        }
        return answer;
    }
}