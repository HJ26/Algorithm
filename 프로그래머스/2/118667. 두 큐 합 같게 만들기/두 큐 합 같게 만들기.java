class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        // 큐 1과 큐 2를 모두 합친 큐 생성
        int N = queue1.length;
        int[] que = new int[N*2];
        
        long sum = 0;            // 총합
        long que1Sum = 0;        // 큐1 합
        for(int i = 0; i < N*2; i++){
            if( i < N ) {
                que[i] = queue1[i];
                que1Sum += que[i];
            }
            else que[i] = queue2[i-N];
            
            sum += que[i];
        }
        
        // 총합이 홀수면 -1 리턴
        if(sum % 2 == 1) return -1;
        
        // 합의 절반
        long target = sum / 2; 
        
        // 큐1 시작부분과 큐2 시작부분을 나타내는 포인터
        int pointerA = 0;
        int pointerB = N;
        while(que1Sum != target){
            // 큐 1의 합이 목표보다 크면 하나 줄이기
            // 원래의 pointerA위치에 있던 값을 빼서 B에 넣기
            // 즉, pointerA의 위치를 뒤로 한칸 이동
            if(que1Sum > target){               
                que1Sum -= que[pointerA++];
                if(pointerA == N*2) pointerA = 0;   // 범위 넘어가면 시작지점으로
            }else{  // B를 A로 이동 ( pointerB를 뒤로 한칸 밀기 )
                que1Sum += que[pointerB++];
                if(pointerB == N*2) pointerB = 0;   // 범위 넘어가면 시작지점으로
                
            }
            // 이동횟수 추가
            answer++;
            // 처음으로 돌아오면 -1 리턴
            if(pointerA == 0 && pointerB == N || pointerA >= pointerB) return -1;
            
        }
        
        return answer;
    }
}