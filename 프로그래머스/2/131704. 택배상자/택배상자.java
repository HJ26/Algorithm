import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> container = new Stack<>();
        
        int N = order.length;
        int idx = 0;
        
        for(int i = 1; i <= N; i++){
            container.push(i);
            while(!container.isEmpty()){
                if(container.peek()==order[idx]){
                    container.pop();
                    idx++;
                    answer++;
                }
                else break;
            }
        }
        return answer;
    }
}