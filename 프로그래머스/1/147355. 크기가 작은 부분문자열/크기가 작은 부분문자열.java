class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int lenP = p.length();
        
        for(int i = 0; i <= t.length()-lenP; i++){
            String tmp = t.substring(i, i + lenP);
            if(tmp.compareTo(p) <= 0) answer++;
        }
        
        return answer;
    }
}