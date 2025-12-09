class Solution {
    public int solution(int num) {
        int answer = 0;
        long tmp = (long) num;
        
        while(tmp != 1 && answer < 500){
            answer++;
            if(tmp%2 == 0) tmp /= 2;
            else tmp = tmp * 3 + 1;
        }
        return answer == 500 ? -1 : answer;
    }
}