class Solution {
    public int solution(String s) {
        int answer = s.length();
        int cnt = 1;
        for(int i = 1; i <= s.length() / 2; i++){
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i);
            
            for(int startIdx = i; startIdx < s.length(); startIdx += i){
                int endIdx = Math.min(startIdx + i, s.length());
                String compare = s.substring(startIdx, endIdx); 
                if(base.equals(compare)) cnt++;
                else{
                    if(cnt > 1) sb.append(cnt);
                    sb.append(base);
                    cnt = 1;
                    base = compare;
                }
            }
            if(cnt > 1) sb.append(cnt);
            cnt = 1;
            sb.append(base);
            answer = Math.min(answer, sb.length());
            
        }
        
        return answer;
    }
}