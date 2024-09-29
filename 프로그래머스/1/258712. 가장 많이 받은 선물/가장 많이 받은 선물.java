import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        // 사람 인원 수
        int N = friends.length;
        
        // 사람이름 - 인덱스 관계 맵 설정
        Map<String, Integer> friendsInfo = new HashMap<>();
        for(int i = 0; i < N; i++) friendsInfo.put(friends[i], i);
        
        int[][] edges = new int[N][N];
        int[] presentPoint = new int[N];
        int M = gifts.length;
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(gifts[i]);
            int from  = friendsInfo.get(st.nextToken());    // 주는사람
            int to = friendsInfo.get(st.nextToken());       // 받는사람        
            edges[from][to]++;
            edges[to][from]--;
            presentPoint[from]++;
            presentPoint[to]--;
        }
        
        // 배열 순회하면서 많이 받을 사람 체크
        int[] predict = new int[N];
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                if(edges[i][j] > 0) predict[i]++;           // i 가 크면 i 가 받고
                else if(edges[i][j] < 0) predict[j]++;      // j 가 크면 j 가 받고
                else{                                       // 같으면 선물 포인트로 확인
                    if(presentPoint[i] > presentPoint[j]) predict[i]++;
                    else if(presentPoint[i] < presentPoint[j]) predict[j]++;
                }
                answer = Math.max(answer, Math.max(predict[i], predict[j]));
            }
        }
        
        return answer;
    }
}