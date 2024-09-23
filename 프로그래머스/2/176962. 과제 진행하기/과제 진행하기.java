import java.util.*;

class Solution {
    
    // 과제 자료형
    static class Subject{
        String name;
        Time time;
        int playtime;
        
        public Subject(String name, Time time, int playtime){
            this.name = name;
            this.time = time;
            this.playtime = playtime;
        }
    }
    
    // 시간 자료형
    static class Time implements Comparable<Time> {
        
        int hour,  min;
        
        public Time(int hour, int min){
            this.hour = hour;
            this.min = min;
        }
        
        @Override
        public int compareTo(Time o){
            if(o.hour == this.hour) return o.min - this.min;
            return o.hour - this.hour;
        }
        
        @Override
        public String toString(){
            return this.hour + " : " + this.min;
        }
    }
    
    public String[] solution(String[][] plans) {
        
        int N = plans.length;  // 과제 개수
        String[] answer = new String[N];
        int ansIdx = 0;
        
        // 과제 리스트 시작 시간이 빠른순으로 정렬
        Arrays.sort(plans, new Comparator<String[]>(){
            
            @Override
            public int compare(String[] o1, String[] o2){
                Time time1 = transTime(o1[1]);
                Time time2 = transTime(o2[1]);
                return time2.compareTo(time1);
            }
            
        });
        
        
        // 과제 리스트로 변경
        Subject[] subjects = new Subject[N+1];
        for(int i = 0; i < N; i++) subjects[i] = transSubject(plans[i]);
        subjects[N] = new Subject("finish", new Time(99,99), 99);
        
        // 중간에 종료된 과제의 인덱스 번호가 들어갈 스택
        Stack<Integer> stopSubject = new Stack<>();
        
        // 과제를 순서대로 순회하며 계산
        Time curTime = new Time(0,0);
        Time endTime = new Time(0,0);
        
        for(int i = 0; i < N; i++){
            
            Subject curSub = subjects[i];
            
            // 과제 시작 시간이 현재 시간보다 뒤에 있으면
            // 멈춰둔 과제 실행
            if(curSub.time.compareTo(curTime) < 0){
                
                while(!stopSubject.isEmpty()){
                    int idx = stopSubject.pop();
                    Subject stop = subjects[idx];
                    endTime = plusTime(curTime, stop.playtime);
                    // 과제 종료 시점이 시작 시간보다 뒤에 있으면
                    if(endTime.compareTo(curSub.time) < 0){
                        // 과제 시작 시각과 끝나는 시간사이의 텀을 남은 과제시간으로 저장
                        subjects[idx].playtime = minusTime(curSub.time, endTime);
                        // 스택에 저장
                        stopSubject.push(idx);
                        break;
                    }else{  // 종료 가능하면 정답에 저장
                        answer[ansIdx++] = stop.name;
                        curTime = endTime;
                    }
                }
            }
            
            // 시작해야 하는 과제 시작
            curTime = subjects[i+1].time;
            endTime = plusTime(curSub.time, curSub.playtime);
            // 과제 종료 시점이 시작 시간보다 뒤에 있고, 마지막 과제가 아니면
            if(endTime.compareTo(curTime) < 0 && i != N-1){
                // 과제 시작 시각과 끝나는 시간사이의 텀을 남은 과제시간으로 저장
                subjects[i].playtime = minusTime(curTime, endTime);
                // 스택에 저장
                stopSubject.push(i);
            }else{  // 종료 가능하면 정답에 저장
                answer[ansIdx++] = curSub.name;
                curTime = endTime;      // 과제가 끝난 시간으로 현재 시간 업데이트
            }
        }
        
        // 종료된 과제 차례대로 수행
        while(!stopSubject.isEmpty()){
            int idxSub = stopSubject.pop();
            answer[ansIdx++] = subjects[idxSub].name;
        }
        
        return answer;
    }
    
    // Subject 자료형으로 변경
    private Subject transSubject(String[] plan){
        String name = plan[0];
        Time time = transTime(plan[1]);
        int min = transMin(plan[2]);
        return new Subject(name, time, min);
    }
    // 시간을 숫자형으로 변경
    private Time transTime(String time){
        
        String[] timeTmp = time.split(":");
        int hour = Integer.parseInt(timeTmp[0]);
        int min = Integer.parseInt(timeTmp[1]);
        return new Time(hour, min);
        
    }
    
    // 분을 숫자형으로 변경
    private int transMin(String min){
        return Integer.parseInt(min);
    }
    
    // 시간 더하기
    private Time plusTime(Time time, int playtime){
        
        int hour = time.hour;
        int min = time.min + playtime;
        if(min >= 60) {
            // 추가되는 시간이 2시간 이상일 수도 있는 상황 고려
            // 60으로 나눠준 몫을 기준으로 시간 계산하기
            int nHour = min / 60;
            hour += nHour;
            min -= 60 * nHour;
        }
        return new Time(hour,min);
        
    }
    
    // 시간 차이 구하기
    // 분 기준
    public int minusTime(Time t1, Time t2){
        
        int time1 = t1.hour * 60 + t1.min;
        int time2 = t2.hour * 60 + t2.min;
        return time2 - time1;
        
    }
        
}