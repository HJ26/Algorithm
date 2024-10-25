class Solution {
    static int answer;
    public int solution(int n) {
        
        answer = 0;
        // 탐색
        dfs(2,n-2);
        
        return answer;
    }
    private void dfs(int plus, int point){
        // * 넣으면 끝나는 상황
        // 시작은 무조건 * 이므로 이때 경우의 수 추가하고 종료
        if(point == 3 && plus == 2){
            answer++;
            return;
        }
        
        if(point <= 3) return;
        
        // Math.log(point)/Math.log(3) : 현재 점수 기준 * 이 들어갈 수 있는 개수
        // Math.log(point)/Math.log(3) * 2 : 그만큼 *이 들어갈 때 필요한 plus 개수 ( 즉, 최대 plus 개수 )
        // 최대 plus개수가 현재 plus 개수보다 적으면 결과적으로 plus가 남음 --> 불가능한 수
        // 미리 종료
        if(Math.log(point)/Math.log(3) * 2 < plus) return;
        
        // point가 3으로 나눠지는 수면 * 넣어보기
        if(point % 3 == 0 && plus >= 2) dfs(plus-2, point/3);
        // plus 넣어보기
        dfs(plus+1, point-1);
    }
}