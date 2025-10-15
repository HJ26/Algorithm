import java.util.*;

class Solution {
    
    static int N, minDiff, nGroup;
    static boolean[] visit;
    static List<Integer>[] edges;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        edges = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) edges[i] = new ArrayList<>();
        
        for(int i = 0; i < wires.length; i++){

            edges[wires[i][0]].add(wires[i][1]);
            edges[wires[i][1]].add(wires[i][0]);
            
        }
        
        minDiff = n;
        for(int i = 0; i < wires.length; i++){
            
            // 끊을 와이어
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            visit = new boolean[n+1];
            nGroup = 1; // 연결된 그룹 개수
            findGroup(1, v1, v2);
            minDiff = Math.min(Math.abs(n-nGroup*2), minDiff);
        }
        
        return minDiff;
    }
    
    private void findGroup(int curV, int remove1, int remove2){
        
        // 현재 정점 방문 처리 ( 다시 확인 안함 )
        visit[curV] = true;
        
        // 연결된 정점 확인
        for(int v : edges[curV]){
            // 두 정점이 끊은 와이어 정점과 같으면 넘기기
            if((curV == remove1 && v == remove2) || (curV == remove2 && v == remove1)) continue;
            // 연결된 정점이 이미 확인된 정점이면 넘기기
            if(visit[v]) continue;
            
            // 연결된 그룹 개수 추가해주고 해당 정점과 연결된 정점 확인
            nGroup++;
            findGroup(v, remove1, remove2);
        }
        
        return;
    }
}