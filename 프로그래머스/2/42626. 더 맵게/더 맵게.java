import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        for(int sv : scoville) foods.add(sv);
        
        while(foods.peek() < K){
            if(foods.size() < 2) return -1;
            foods.add(foods.poll() + foods.poll() * 2);
            answer++;
        }
        
        return answer;
    }
}