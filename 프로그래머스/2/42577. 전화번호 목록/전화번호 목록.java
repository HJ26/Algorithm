import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // 정렬
        Arrays.sort(phone_book, new Comparator<String>(){
            
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
            
        });
        
        // 전화번호부를 저장할 맵
        Map<String, String> phone = new HashMap<String, String>();
        
        // 저장된 전화번호의 길이를 저장할 배열과 리스트
        boolean[] isLen = new boolean[21];
        List<Integer> numLen = new ArrayList<Integer>();
        
        // 주어진 번호를 하나씩 탐색
        for(String number : phone_book){
            
            // 현재 번호의 길이
            int length = number.length();
            
            // 지금까지 저장된 번호의 길이만큼 앞에서 잘라서 확인
            // 잘린 길이만큼의 값이 맵에 저장되어 있는지를 확인
            // 키로 등록되어 있으면 접두사가 있다는 의미
            for(int i : numLen){
                if( i > length) break;                      // 현재 번호의 길이보다 길면 다음 번호 확인
                String numTmp = number.substring(0,i);      // 길이만큼 앞에서 가져오기
                if(phone.containsKey(numTmp)) return false; // 키 값으로 있으면 false 리턴
            }
            
            // 현재 번호 맵에 저장
            phone.put(number, "0");
            
            // 지금까지 번호들 중 같은 길이가 없었으면
            // 그 길이 저장해두기
            if(!isLen[length]) {
                isLen[length] = true;
                numLen.add(length);
                Collections.sort(numLen);
            }
            
        }
        
        return true;
    }
}