class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int[] answer = new int[2];
        
        // 수열의 길이
        int seqLen = sequence.length;
        
        // 탐색할 좌우 포인터
        int left = 0;
        int right = left;
        
        // 정답이 될 좌우 포인터
        int minLeft = left;
        int minRight = seqLen-1;
        
        int sum = sequence[left];
        while(left <= right && left < seqLen){
            
            // 길이가 현재 최소길이보다 작은 경우
            // 최소값 갱신
            if(sum == k && (right-left) < (minRight-minLeft)){
                minLeft = left;
                minRight = right;
                if(minLeft == minRight) break;
            }
            
            if(sum >= k) sum -= sequence[left++];      // 합이 k 보다 크면 왼쪽을 늘려서 구간 줄이고
            else if(right == seqLen-1) break;          // 오른쪽 구간이 마지막 구간이면 더 늘릴 수 없으므로 종료
            else sum += sequence[++right];             // k보다 작으면 오른쪽 늘려서 구간 늘리기
            
            
        }
        
        answer[0] = minLeft;
        answer[1] = minRight;
        return answer;
    }
}