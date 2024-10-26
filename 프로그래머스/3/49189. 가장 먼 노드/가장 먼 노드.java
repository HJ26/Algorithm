import java.util.*;

class Solution {

    
    public int solution(int n, int[][] edge) {
        
        int answer = 0;         // 최장거리 정점 개수
        int maxDist = 1;        // 최장거리 저장 변수
        
        // 변수 초기화
        int notVisitVertex = n-1;
        
        // 최단거리 저장
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // 간선 정보 저장
        List<Integer>[] edges = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            edges[i] = new ArrayList<>();
        }
        
        // 방문 여부 저장
        boolean[] visit = new boolean[n+1];
        visit[1] = true;
        
        // 간선 정보 저장
        int M = edge.length;
        
        for(int i = 0; i < M; i++){
            edges[edge[i][0]].add(edge[i][1]);
            edges[edge[i][1]].add(edge[i][0]);
        }
        
        // 1번 정점에서 시작하는 경로 저장
        Queue<int[]> que = new LinkedList<>();
        
        for(int v : edges[1]){
            visit[v] = true;
            dist[v] = 1;
            notVisitVertex--;
            que.add(new int[] { v, 1 });
        }
        
        // BFS 시작
        bfs: while(!que.isEmpty()){
            
            // 현재 정점 정보
            int[] cur = que.poll();
            int vertex = cur[0];
            int curDist = cur[1];
            
            // 현재 정점에서 연결되어 있는 정점 정보 업데이트
            
            for(int v : edges[vertex]){
                
                // 이미 방문한 점이면 넘기기
                if(visit[v]) continue;
                
                // 방문했으면 정보 업데이트
                visit[v] = true;                            // 방문 처리
                dist[v] = Math.min(dist[v], curDist+1);     // 최단 거리 업데이트
                maxDist = Math.max(dist[v], maxDist);       // 최장 거리 업데이트
                que.add(new int[] { v, curDist+1 });        // 연결된 정점 정보 큐에 저장
                notVisitVertex--;                           // 연결 못한 정점 개수 한개 감소
                if( notVisitVertex == 0 ) break bfs;         // 모든 정점이 연결되었으면 종료
            }
        }
        
        // 최장 길이 구하기
        for(int d : dist){
            if( d == maxDist ) answer++;    // 거리가 최대거리랑 같으면 개수 추가
        }
        
        return answer;
    }
}