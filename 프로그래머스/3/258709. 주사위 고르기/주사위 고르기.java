import java.util.*;

class Solution {
    
    static final int NDICE = 6;
    static int N;
    static List<Integer> choice = new ArrayList<>();
    static int[][] dices;
    static List<Integer> arrA;
    static List<Integer> arrB;
    static int[] answer;
    static int max = Integer.MIN_VALUE;
    
    public int[] solution(int[][] dice) {
        
        N = dice.length;
        dices = dice;
        answer = new int[N/2];
        choiceDice(0,0);
        
        return answer;
    }
    
    private static void choiceDice(int depth, int s){
        if(depth == N/2){
            int winProb = getWinProb();
            if(max < winProb){
                max = winProb;
                for(int i = 0; i < choice.size(); i++){
                    answer[i] = choice.get(i)+1;
                }
            }
            return;
        }
        
        for(int i = s; i < N; i++){
            choice.add(i);
            choiceDice(depth+1, i+1);
            choice.remove(choice.size()-1);
        }
    }
    
    private static int getWinProb(){
        int cnt = 0;
        
        makeArrAB();
        Collections.sort(arrB);
        
        for(int i =0 ; i < arrA.size(); i++){
            int num = arrA.get(i);
            int left = 0;
            int right = arrB.size() - 1;
            int idx = Integer.MIN_VALUE;
            
            while(left <= right){
                int mid = (left + right)/2;
                if(arrB.get(mid) < num){
                    left = mid+1;
                    idx = Math.max(idx, mid);
                } else right = mid - 1;
            }
            
            if(idx != Integer.MIN_VALUE) cnt += idx + 1;
        }
        return cnt;
    }
    
    private static void makeArrAB(){
        arrA = new ArrayList<>();
        arrB = new ArrayList<>();
        
        int[][] diceA = new int[N/2][NDICE];
        int[][] diceB = new int[N/2][NDICE];
        
        int a = 0;
        int b = 0;
        for(int i = 0; i < N; i++){
            if(choice.contains(i)){
                diceA[a] = dices[i];
                a++;
            }else{
                diceB[b] = dices[i];
                b++;
            }
        }
        
        makeArr(0, diceA, 0, arrA);
        makeArr(0, diceB, 0, arrB);
            
    }
    
    private static void makeArr(int depth, int[][] dice, int sum, List<Integer> arr){
        if(depth == N/2){
            arr.add(sum);
            return;
        }
        
        for(int i = 0; i < NDICE; i++){
            int newSum = sum + dice[depth][i];
            makeArr(depth + 1, dice, newSum, arr);
        }
    }
    
}