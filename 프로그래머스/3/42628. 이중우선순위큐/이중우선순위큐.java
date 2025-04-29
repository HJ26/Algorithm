import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
    
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        int len = 0;
        
        StringTokenizer st;
        for(int i = 0; i < operations.length; i++){
            st = new StringTokenizer(operations[i]);
            String act = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(act.equals("I")){
                min.add(num);
                max.add(num);
                len++;
            }else{
                if(len == 0) continue;
                if(num == 1){
                    max.poll();                    
                    len--;
                    if(len == 1){
                        min.clear();
                        min.add(max.peek());
                    }
                }else{
                    min.poll();
                    len--;
                    if(len == 1){
                        max.clear();
                        max.add(min.peek());
                    }
                }
                if(len == 0){
                    max.clear();
                    min.clear();
                }
            }
        }
        
        if(len == 0){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        
        return answer;
    }
}