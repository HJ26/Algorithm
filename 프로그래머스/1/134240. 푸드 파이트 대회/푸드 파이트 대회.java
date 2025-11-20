import java.util.*;

class Solution {
    public String solution(int[] food) {
        
        StringBuilder answer = new StringBuilder();
        
        Stack<Integer> back = new Stack<>();
        for(int i = 0; i < food.length; i++){
            int n = food[i] / 2;
            for(int j = 0; j < n; j++){
                answer.append(i);
                back.add(i);
            }
        }
        
        answer.append(0);
        while(!back.isEmpty()) answer.append(back.pop());
        
        return answer.toString();
    }
}