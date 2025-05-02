import java.util.*;

class Solution {
    
    static int[] work;
    static int curTime;
    
    static class Disk implements Comparable<Disk> {
        int time;
        int start;
        int no;
        
        public Disk(int time, int start, int no){
            this.time = time;
            this.start = start;
            this.no = no;
        }
        
        @Override
        public int compareTo(Disk o){
            if(this.time == o.time){
                if(this.start == o.start) return this.no - o.no;
                return this.start - o.start;
            }
            return this.time - o.time;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        
        int N = jobs.length;
        work = new int[N];
        PriorityQueue<Disk> controller = new PriorityQueue<>();
        curTime = 0;
        
        // 요청 시간 기준으로 정렬
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                // 요청시간이 같은 경우 처리 시간이 짧은 순서로 정렬
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        
        for(int i = 0; i < N; i++){
            // 업무 요청 받기
            Disk nDisk = new Disk(jobs[i][1], jobs[i][0], i);
            
            // curTime 이 disk의 요청시간보다 작을때까지 업무 반복
            while(!controller.isEmpty() && curTime < nDisk.start){
                Disk cDisk = controller.poll();
                work(cDisk);
            }
            
            // 요청된 업무 수행
            // 컨트롤러가 비어있고, 진행 중인 업무가 없는 경우 그대로 업무 수행
            if(controller.isEmpty() && curTime <= nDisk.start) work(nDisk);
            // 비어있지 않거나 업무가 진행중이면 컨트롤러에 추가
            else controller.add(new Disk(nDisk.time, nDisk.start, nDisk.no));
        }
        
        // 남아있는 컨트롤러 업무 수행
        while(!controller.isEmpty()) work(controller.poll());

        for(int i : work) answer += i;
        return answer / N;
    }
    
    // 업무 시행
    public void work(Disk cDisk){
        if(curTime < cDisk.start) curTime = cDisk.start + cDisk.time;
        else curTime += cDisk.time;
        work[cDisk.no] = curTime - cDisk.start;
    }
}