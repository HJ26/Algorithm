class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        
        int N = balls.length;
        int[] answer = new int[N];
        
        for(int i = 0; i < N; i++ ){
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            int now = 0;
            int rslt = Integer.MAX_VALUE;
            
            if (!(startY == targetY && startX >= targetX)) {
                now = dist(startX, startY, targetX * (-1), targetY);
                rslt = Math.min(now, rslt);
            }
            
            if (!(startY == targetY && startX <= targetX)) {
                now = dist(startX, startY, m + (m - targetX), targetY);
                rslt = Math.min(now, rslt);
            }
            
            if (!(startX == targetX && startY <= targetY)) {
                now = dist(startX, startY, targetX, n + (n - targetY));
                rslt = Math.min(now, rslt);
            }
            
            if (!(startX == targetX && startY >= targetY)) {
                now = dist(startX, startY, targetX, targetY * (-1));
                rslt = Math.min(now, rslt);
            }

            answer[i] = rslt;
        
        }
        
        return answer;
    }
    
    private static int dist(int sx, int sy, int tx, int ty) {
        return (int) (Math.pow(sx - tx, 2) + Math.pow(sy - ty, 2));
    }
}