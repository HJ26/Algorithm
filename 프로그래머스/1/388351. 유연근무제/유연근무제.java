import java.util.*;

class Solution {
    
    static class Time{
        int hour;
        int min;
        
        public Time(int time){
            this.hour = time / 100;
            this.min = time % 100;
        }
        
        public boolean timeDiff(Time t1){
            int time1 = t1.min + t1.hour * 60;
            int time2 = this.min + this.hour * 60;
            return time2 - time1 <= 10 ? true : false;
        }
    }
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int N = schedules.length;
        boolean[] prize = new boolean[N];
        Arrays.fill(prize, true);
        
        for(int day = 0; day < 7; day++, startday++){
            if(startday > 7) startday = 1;
            if(startday > 5) continue;
            
            for(int i = 0; i < N; i++){
                if(!prize[i]) continue;
                Time hope = new Time(schedules[i]);
                Time real = new Time(timelogs[i][day]);
                if(!real.timeDiff(hope)) prize[i] = false;
            }
        }
        
        for(boolean b : prize) if(b) answer++;
        return answer;
    }
}