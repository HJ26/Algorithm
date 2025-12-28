class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String str : s.split(" ")){
            min = Math.min(Integer.parseInt(str), min);
            max = Math.max(Integer.parseInt(str), max);
        }
        
        answer.append(min+" "+max);
        return answer.toString();
    }
}