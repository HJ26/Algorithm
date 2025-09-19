import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++){
            int tmp = number.charAt(i)-'0';
            if(!stack.isEmpty() && stack.peek() < tmp){
                while(k > 0 && !stack.isEmpty() && stack.peek() < tmp){
                    stack.pop();
                    k--;
                }
            }
            stack.add(tmp);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        while(!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }
}