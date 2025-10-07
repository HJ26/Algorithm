class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int nStone = storey % 10;
            storey /= 10;
            if(nStone > 5 || ( nStone == 5 && storey % 10 >= 5)){
                storey++;
                nStone = 10-nStone;
            }
            answer += nStone;
        }
        
        return answer;
    }
}