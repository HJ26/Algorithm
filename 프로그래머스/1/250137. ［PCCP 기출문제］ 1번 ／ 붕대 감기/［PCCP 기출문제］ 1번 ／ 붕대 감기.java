class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // 공격횟수
        int N = attacks.length;
        
        // 현재 체력
        int curHealth = health;
        int healTime = 0;
        
        // 공격 시작
        for(int i = 0; i < N-1; i++){
            
            // 현재 체력에서 공격력만큼 감소
            curHealth -= attacks[i][1];
            
            // 0 이하가 되면 종료
            if(curHealth <= 0) break;
            
            // 회복할 수 있는 시간 구하기
            healTime = attacks[i+1][0] - attacks[i][0] -1;
            // 회복할 수 있는 시간 / 뢰복에 필요한 시간 --> 보너스 체력 얻을 수 있는 횟수
            // healTime * bandage[1] : 시간초동안 총 회복량
            curHealth += (healTime / bandage[0]) * bandage[2] + healTime * bandage[1];
            
            // 최대체력 이상이면 최대체력으로 변경
            if(curHealth > health) curHealth = health;
            
        }
        
        // 마지막 공격 실행
        curHealth -= attacks[N-1][1];
        
        // 체력이 0 이하먄 -1 로 변경
        if(curHealth <= 0) curHealth = -1;
        // 최종 체력 return
        return curHealth;
    }
}