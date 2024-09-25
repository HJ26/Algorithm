import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];  // 맨 위의 값 넣기
        
        // 아래에서 위로 탐색
        // 내 값 기준 위의 열의 왼쪽, 오른쪽 값과의 합 구하기 -> 더 큰 값 저장
        for(int i = 1; i < N; i++){ // 행 번호
            // 맨 왼쪽 열의 경우
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            // 중간 라인
            for(int j = 1; j <= i; j++){
                // Math.max(dp[i-1][j], dp[i-1][j-1]) : 왼쪽, 오른쪽 값 중 큰 값
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
            
            // 맨 오른쪽의 경우
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        
        // 큰 값 찾기
        for(int i = 0; i < N; i++){
            answer = Math.max(answer, dp[N-1][i]);
        }

        return answer;
    }
}