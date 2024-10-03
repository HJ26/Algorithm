class Solution {
    
    static int videoLen, curTime, opStart, opEnd;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        
        videoLen = transMinute(video_len);
        curTime = transMinute(pos);
        opStart = transMinute(op_start);
        opEnd = transMinute(op_end);
        
        int N = commands.length;
        curTime = checkOpening(curTime);
        for(int i = 0; i < N; i++){
            
            switch(commands[i]){
                case "prev":
                    curTime = prev(curTime);
                    break;
                
                case "next":
                    curTime = next(curTime);
                    break;

            }
            
        }
        
        int min = curTime / 60;
        int sec = curTime % 60;
        
        String minutes = min < 10 ? "0"+ min : Integer.toString(min);
        String seconds = sec < 10 ? "0" + sec : Integer.toString(sec);
        return minutes + ":" + seconds;
    }
    
    private int prev(int curTime){
        return curTime-10 < 0 ? checkOpening(0) : checkOpening(curTime - 10);
    }
    
    private int next(int curTime){
        return curTime + 10 > videoLen ? videoLen : checkOpening(curTime + 10);
    }
    
    private int checkOpening(int curTime){
        if( curTime >= opStart && curTime <= opEnd) return opEnd;
        return curTime;
    }
    
    private int transMinute(String time){
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
    
}