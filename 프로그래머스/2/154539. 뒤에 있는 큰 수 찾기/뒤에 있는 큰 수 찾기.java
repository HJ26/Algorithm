import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        // 숫자 개수
        int N = numbers.length;
        
        // 숫자 개수만큼 뒷 큰수 배열 생성
        int[] answer = new int[N];
        Arrays.fill(answer, -1);    // 값이 없는 경우 -1 이므로 기본 값 -1로 채우기
        
        // 순회하면서 확인
        
        // 뒷큰수를 못찾은 숫자의 인덱스, 숫자를 저장할 우선순위 큐
        // 숫자를 기준으로 오름차순 정렬
//         PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>(){
            
//             @Override
//             public int compare(int[] num1, int[] num2){
//                 return num1[1] - num2[1];
//             }
            
//         });
        
        // 뒷큰수가 안채워진 배열의 인덱스를 저장할 스택
        Stack<Integer> small = new Stack<Integer>();
        
         // 순회하면서 채우기
        for(int i = 0; i < N; i++){
            
            // 아직 뒷큰수 배열이 안채워진 숫자 확인
            while(!small.isEmpty()){
                
                int idx = small.peek();
                
                // 안채워진 숫자가 현재 숫자보다 크거나 같으면 못채움
                // 멈추기
                if(numbers[idx] >= numbers[i]) break;
                // 작으면 채우고
                answer[idx] = numbers[i];
                // 현재 순서 스택에서 삭제
                small.pop();
            }
            // 지금 숫자로 채울 수 있는 칸 다 채웠으므로
            // 스택에 넣기
            small.push(i);
        }    
        
        return answer;
    }
}