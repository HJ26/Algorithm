class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int tmp : arr) answer += tmp;
        return answer / arr.length;
    }
}