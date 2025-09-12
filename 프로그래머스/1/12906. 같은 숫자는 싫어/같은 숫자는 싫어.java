import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        
        Stack<Integer> answer = new Stack<>();
        
        for(int num : arr){
            if(answer.isEmpty() || answer.peek() != num) answer.add(num);
        }
        
        return answer;
    }
}