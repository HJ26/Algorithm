import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // participant 에 없는 한명을 찾는 함수 만들기
        // participant 를 순회하면서 map 만들기
        // key 값이 없으면 0으로 만들고, 있으면 +1
        Map<String, Integer> marathon = new HashMap<String, Integer>();
        for( String partName : participant){
        	marathon.put(partName, marathon.getOrDefault(partName,0)+1);
        }
        
        // completion 순회하면서 map에 해당하는 값 1씩 감소
        for( String compleName : completion) marathon.put(compleName, marathon.get(compleName)-1);
        
        // map 순회하면서 value 가 0이 아닌 key값 찾기
        for( String player : marathon.keySet() ) {
        	if( marathon.get(player) != 0 ) {
        		answer = player;
        		break;
        	}
        }
        
        // 출력
        return answer;
    }
}