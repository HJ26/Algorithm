class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1) return new int[] {-1};
        
        int minIdx = 0;
        for(int i = 0; i < arr.length; i++) minIdx = arr[i] < arr[minIdx] ? i : minIdx;
        
        int idx = 0;
        int sidx = 0;
        int[] answer = new int[arr.length-1];
        while(sidx < arr.length-1){
            if(idx == minIdx) idx++;
            answer[sidx++] = arr[idx++];
        }
              
        return answer;
    }
}