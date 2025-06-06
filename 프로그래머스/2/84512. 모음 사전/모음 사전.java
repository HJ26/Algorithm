class Solution {
    public int solution(String word) {
        
        String str = "AEIOU";
        int[] nums = {781, 156, 31, 6, 1};
        int answer = word.length();
        
        for (int i = 0; i < word.length(); i++) {
            int idx = str.indexOf(word.charAt(i));
            answer += nums[i] * idx;
        }

        return answer;
    }
}