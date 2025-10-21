import java.util.*;

class Solution {
    
    public int solution(int[][] routes) {
        int answer = 1;
    
        // 끝지점이 작은 순서대로 정렬
        // 시작지점이 같은경우 빨리 끝나는 지점 순서로 정렬
        Arrays.sort(routes, new Comparator<int[]>(){
            
            @Override
            public int compare(int[] r1, int[] r2){
                return r1[1] - r2[1];
            }
            
        });
        
        int curE = routes[0][1];
        int idx = 1;
        while(idx < routes.length){
        
            // 새로운 지점의 시작지점이
            // 기존 지점의 끝나는 지점과 겹치지 않으면
            // 개수 +1 하고 끝나는 지점 업데이트
            if( routes[idx][0] > curE ){
                answer++;
                curE = routes[idx][1];
            }else if(routes[idx][1] < curE){
                // 다음 지점의 끝나는 지점이
                // 원 지점의 끝나는 지점보다 앞에 있으면
                // 끝나는 지점 업데이트
                curE = routes[idx][1];
            }
            // 다음 지점 확인하기
            idx++;
            
        }
    
        
        return answer;
    }
} 