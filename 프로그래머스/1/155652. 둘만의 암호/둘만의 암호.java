class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
     
        for(int i = 0; i < s.length(); i++){
            
            char next = s.charAt(i);
            
            for(int j = 0; j < index; j++){
                next++;
                if( next > 'z') next -= 26;
                if( skip.contains(String.valueOf(next))) j--;
            }
            
            answer.append(next);
        }
        return answer.toString();
    }
}