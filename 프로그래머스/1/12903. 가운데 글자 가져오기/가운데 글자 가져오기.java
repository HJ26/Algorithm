class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = s.length() / 2;
        
        if(s.length()%2 == 0) sb.append(s.charAt(idx-1)).append(s.charAt(idx));
        else sb.append(s.charAt(idx));
        
        
        return sb.toString();
    }
}