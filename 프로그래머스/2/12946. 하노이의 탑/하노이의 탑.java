class Solution {
    static int idx = 0;
    public int[][] solution(int n) {
        int[][] answer = new int[(int) Math.pow(2,n)-1][2];
        
        hanoi(n,1,3,2,answer);
        
        return answer;
    }
    
    private void hanoi(int num, int start, int end, int mid, int[][] answer){
        
        if(num == 1) {
            answer[idx++] = new int[] {start, end};
            return;
        }
        
        hanoi(num-1, start, mid, end, answer);
        answer[idx++] = new int[] {start, end};
        hanoi(num-1, mid, end, start, answer);
        
    }
    
}