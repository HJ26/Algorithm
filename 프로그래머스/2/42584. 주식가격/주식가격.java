import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        int N = prices.length;
        answer = new int[N];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()] ){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            answer[stack.peek()] = N - stack.pop() - 1;
        }
        
        return answer;
    }
}