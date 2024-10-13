import java.util.*;

class Solution {
    
    // N : 팀원 수
    static int N;
    static List<Integer>[] team;  // 팀 관계 저장
    static int[][] cost;          // 팀 별 최소 금액 저장
    static int[] extra;           // 한 팀에서 모두가 참석 안했을 경우 최소 금액 저장
    
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        
        N = sales.length;
        team = new ArrayList[N+1];
        cost = new int[N+1][2];
        extra = new int[N+1];
        
        // 팀 관계 저장
        Arrays.setAll(team, i -> new ArrayList<Integer>());
        for(int[] link: links) team[link[0]].add(link[1]);
        
        // 탐색
        // CEO를 시작으로 탐색 시작
        workshop(1, sales);

        // 탐색 다 했으면 1번 기준으로 최소값 출력
        return Math.min(cost[1][0], cost[1][1]);
    }
    
    private void workshop(int teamId, int[] sales){
        
        // 팀장이 맡도 있는 팀 별 금액 구히가
        int nMember = team[teamId].size();
        
        // 팀장의 참석 여부 정보 저장하기
        cost[teamId][0] = 0;                    // 참석 안한 경우
        cost[teamId][1] = sales[teamId-1];      // 참석 한 경우
        
        // 팀원이 없는 경우 넘기기
        if(nMember == 0) return;
        
        int extra = Integer.MAX_VALUE;
        // 팀원 별 참석 여부 결정하기
        for(int memberId : team[teamId]){
            
            // 팀원 팀 참석
            workshop(memberId, sales);
            
            // 팀원이 참석안 한 경우 < 팀원이 참석 한 경우 ==> 팀원이 참석안한 경우
            if(cost[memberId][0] < cost[memberId][1]){
                cost[teamId][0] += cost[memberId][0];
                cost[teamId][1] += cost[memberId][0];
                
                // 팀원, 팀장 모두 참석 안한 경우 존재 가능 --> 한 명이라고 참석 해야 함
                // 참석 안 한 경우는 위에서 이미 더함
                // 즉, 참석 한 경우와 안한 경우의 차이만 추가로 더해주면 됨 ( 그럼 내가 참석한 경우와 값이 같으므로 )
                // 해당 값이 가장 작은 멤버 값 더해주기
                extra = Math.min(extra, cost[memberId][1] - cost[memberId][0]);      
            } else {    // 팀원이 참석 한 경우
                cost[teamId][0] += cost[memberId][1];
                cost[teamId][1] += cost[memberId][1];
                
                extra = 0;      // 팀원, 팀장 모두 참석 안한 경우 존재 X --> 0 으로 초기화
            }  
        }
        // 자식 다 확인 완료
        // 아무도 참석 안한 경우 가장 최소갑 더하기
        cost[teamId][0] += extra;
        
    }
}