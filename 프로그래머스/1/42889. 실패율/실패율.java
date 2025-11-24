import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        // 사람 수
        int M = stages.length;
        
        // 스테이지 별 클리어 하지 못한 사람 수
        int[] currentStages = new int[N+1];
        // 스테이지별 도달한 사람 수
        int[] clearStages = new int[N+1];
        
        for(int i = 0; i < M; i++){
            // 스테이지에 도달한 플레이어 수 증가
            for(int j = 0; j < stages[i]; j++){
                clearStages[j]++;
            }
            
            // 도달했지만 클리어 하지 못한 플레이어 수 증가
            currentStages[stages[i]-1]++;
            
        }
        
        // 스테이지 번호 및 실패율
        Map<Integer, Double> failRates = new HashMap<>();
        for(int i = 0; i < N; i++){
            if(currentStages[i] == 0 || clearStages[i] == 0){
                failRates.put(i+1, 0.0);
            }else{
                failRates.put(i+1, (double) currentStages[i] / (double) clearStages[i]);
            }
        }
        
        List<Integer> list = new ArrayList<>(failRates.keySet());
        list.sort((o1, o2) -> Double.compare(failRates.get(o2), failRates.get(o1)));
        
        return list.stream().mapToInt(i -> i).toArray();    
    }
}