class Solution {
    static int answer = 0;
    public int solution(int n) {
        
        find(n,n);
        
        return answer;
        
    }
    
    
    private void find(int left, int right){
        
        // 왼쪽 괄호 다 썻으면 오른쪽 쭉 넣으면 됨
        // 개수 추가하고 리턴
        if( left == 0 ) {
            answer++;
            return;
        }
        
        // 왼쪽, 오른쪽 괄호 개수가 같으면 왼쪽 가져오기
        if( left == right ) find(left-1, right);
        else{   // 같지 않으면 왼쪽 쓰거나, 오른쪽 쓰거나 선택
            find(left-1, right);
            find(left, right-1);
        }
        
    }
}