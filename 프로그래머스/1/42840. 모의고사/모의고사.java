import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        
        // 패턴 저장
        int[] first = { 1,2,3,4,5 };
        int[] second = { 2,1,2,3,2,4,2,5 };
        int[] third = { 3,3,1,1,2,2,4,4,5,5 };
        
        // 점수구하기
        int[] score = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == first[i%5]) score[0]++;
            if(answers[i] == second[i%8]) score[1]++;
            if(answers[i] == third[i%10]) score[2]++;
        }
        
        // 등수 구하기
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        
        // 최고 점수 사람 구하기
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < 3; i++) if(score[i] == maxScore) answer.add(i+1);
        return answer;
    }
}