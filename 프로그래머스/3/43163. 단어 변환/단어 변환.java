import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {

        // 타겟 단어가 배열 안에 있는지 확인
        int N = words.length;
        if(!includeTarget(target, words)) return 0; 
        
        // 각 문자열별로 1개씩 다른 단어 찾기
        boolean[][] isChangeWords = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(oneChange(words[i], words[j])){
                    isChangeWords[i][j] = isChangeWords[j][i] = true;
                }
            }
        }
        
        // 변할 수 있는 단어 변경하면서 target 찾을 수 있는지 확인
        // bfs
        Queue<int[]> que = new LinkedList<>();
        boolean[] visit = new boolean[N];
        
        // begin 이 변할 수 있는 단어 찾아서 큐에 넣기
        for(int i = 0; i < N; i++){
            if(oneChange(begin, words[i])) {
                que.add(new int[] {i, 1});
                visit[i] = true;
            }
        }
      
        // 시작
        while(!que.isEmpty()){
            
            int[] cur = que.poll();
            int idx = cur[0];
            int nMove = cur[1];
            
            // 타겟 단어이면 끝내기
            if(words[idx].equals(target)) return nMove;
            
            // 타겟 아니면 움직이기
            for(int i = 0; i < N; i++){
                // i번째 단어가 idx에서 변할 수 있고, 방문한 적 없으면 이동 후 큐에 넣기
                if(isChangeWords[idx][i] && !visit[i]) {
                    que.add(new int[] {i, nMove+1});
                    visit[i] = true;                        // 방문처리
                }
            }
            
            
        }
        return 0;
    }
    
    
    // 타겟 단어가 배열 안에 있는지 순회하면서 확인
    private boolean includeTarget(String target, String[] words){
        
        for(String s : words){
            if(s.equals(target)) return true;
        }
        
        return false;
    }
    
    // 단어가 1개만 바뀔 수 있는지 확인
    private boolean oneChange(String str1, String str2){
        int N = str1.length();
        int nDiff = 0;
        
        for(int i = 0; i < N; i++){
            if(str1.charAt(i) != str2.charAt(i)) nDiff++;   // 다르면 nDiff + 1
            if(nDiff > 1) return false;                     // 1개 이상 다르면 false
        }
        
        if(nDiff == 1) return true;                         // 1개만 다르면 true
        
        return false;
    }
}