import java.util.*;

class Solution {
    
    static int[][] map;
    static int N, M, H, W, T;
    
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        
        N = m; M = n; H = h; W = w; T = drops.length;
        
        map = new int[N][M];
        for(int[] row : map) Arrays.fill(row, T);
        
        for(int t = 0; t < T; t++){
            int r = drops[t][0];
            int c = drops[t][1];
            map[r][c] = Math.min(t, map[r][c]);
        }
        
        int left = 0, right = T;
        int[] answer = { 0, 0 };
        
        // t 번째 빗방울에 대한 안전지대 체크
        // 안전지대가 없어지는 시점의 Upper Bound
        while(left <= right){
            int mid = (left+right) / 2;
            int[] pos = findSafeZone(mid);
            
            if(pos != null){
                answer = pos;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    
    private int[] findSafeZone(int T){
        int[][] pSum = new int[N+1][M+1];
        
        // 2차원 누적 합 배열 생성
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int tmp = (map[i][j] < T) ? 1 : 0;
                pSum[i+1][j+1] = tmp + pSum[i][j+1] + pSum[i+1][j] - pSum[i][j];
            }
        }
        
        // 선인장 범위 탐색
        for(int i = H; i <= N; i++){
            for(int j = W; j <= M; j++){
                int sum = pSum[i][j] - pSum[i-H][j] - pSum[i][j-W] + pSum[i-H][j-W];
                if(sum == 0) return new int[] { i - H, j - W };
            }
        }
        return null;
    }
}