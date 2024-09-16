class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int L = s.length();
        
        // 문자열 순서대로 확인
        int open = 0;
        for(int i = 0; i < L; i++){
            
            char str = s.charAt(i);
            if(str == '(') open++;  // 열림 괄효면 +1
            else open--;            // 닫힘 괄호면 -1
            
            if(open < 0){           // 닫힘 괄호가 더 많으면
                answer = false;     // 실패 처리하고
                break;              // 종료
            }
        }
        
        // 탐색 끝나고
        // 열려있는 괄호가 남아있으면 false
        if(open > 0) answer = false;
        
        return answer;
    }
}