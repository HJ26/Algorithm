class Solution {
    
    static double[] rate = { 0.1, 0.2, 0.3, 0.4 };
    static int[] answer;
    static int[] disRate;
    static int maxDiscIdx = 4;
        
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[] { -1, -1 };
        
        int max = 0;
        for(int i = 0; i < users.length; i++){
            max = Math.max(users[i][0],max);
        }
        
        for(int i = 0; i < 4; i++){
            if(rate[i]*100 > max){
                maxDiscIdx = i+1;
                break;
            }
        }
        
        disRate = new int[emoticons.length];
        discount(0,users,emoticons);
        
        return answer;
    }
    
    
    private void discount(int idx, int[][] users, int[] emoticons){
        
        if(idx == emoticons.length){
            check(users, emoticons);
            return;
        }
        
        for(int i = 0; i < maxDiscIdx; i++){
            disRate[idx] = i;
            discount(idx+1, users, emoticons);
        }
        
    }
    
    private void check(int[][] users, int[] emoticons){
        int nPlus = 0;
        int sales = 0;
        for(int i = 0; i < users.length; i++){
            double point = users[i][0] * 0.01;
            int total = 0;
            for(int j = 0; j < emoticons.length; j++){
                if(rate[disRate[j]] >= point){
                    total += emoticons[j] * (1-rate[disRate[j]]);
                }
            }
            if(total >= users[i][1]) nPlus++; 
            else sales += total;
        }
        
        if(nPlus > answer[0]){
            answer[0] = nPlus;
            answer[1] = sales;
        }else if(nPlus == answer[0]) {
            answer[1] = Math.max(answer[1], sales);
        }
                 
    }
}