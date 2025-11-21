class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = Integer.toString(n,3);
        
        String reverse = new StringBuilder(str).reverse().toString();
        
        answer = Integer.valueOf(reverse, 3);
        return answer;
    }
}