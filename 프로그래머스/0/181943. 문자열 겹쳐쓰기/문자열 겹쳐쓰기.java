class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder answer = new StringBuilder();
        
        return answer.append(my_string.substring(0,s)).append(overwrite_string).append(my_string.substring(s+overwrite_string.length(), my_string.length())).toString();
    }
}