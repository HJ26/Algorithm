import java.util.*;

class Solution {
    
    static int root, size;
    static Node[] tree;
    static int[ ] parent;
    
    static class Node{
        int left, right;
        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    
    public int solution(int k, int[] num, int[][] links) {
        
        // 트리 구성하기
        setTree(num, links);
        
        // 탐색 시작
        int low = 0;
        int high = 0;
        
        // 한 그룹의 최소, 최대 값 찾기
        for(int n : num) {
            low = Math.max(low, n);
            high += n;
        }
        
        // 탐색 시작
        while(low <= high){
            int mid = (low + high) / 2;
            
            // 그룹이 k 개 이하면
            // 값 키우기
            if(checkGroup(num, mid) <= k) high = mid - 1;
            else low = mid + 1; // 아니면 값 줄이기
        }
        return high + 1;
    }
    
    private void setTree(int[] num, int[][] links){
        int N = num.length;
        tree = new Node[N];
        parent = new int[N];
        
        Arrays.fill(parent, -1);
        
        for(int i = 0; i < N; i++){
            tree[i] = new Node(links[i][0], links[i][1]);
            if(tree[i].left != -1) parent[tree[i].left] = i;
            if(tree[i].right != -1) parent[tree[i].right] = i;
        }
        
        for(int i = 0; i < N; i++){
            if(parent[i] == -1){
                root = i;
                break;
            }
        }
    }
    
    private int checkGroup(int[] num, int max){
        size = 0;
        dfs(num, root, max);
        return size+1;
    }
    
    private int dfs(int[] num, int cur, int max){
        
        int lv = 0, rv = 0;
        
        if(tree[cur].left != -1)
            lv = dfs(num, tree[cur].left, max);
        if(tree[cur].right != -1)
            rv = dfs(num, tree[cur].right, max);
        
        //자식 노드들과 자신의 값의 합이 max보다 작거나 같으면 자를 필요가 없다.
        if(num[cur] + lv + rv <= max) 
            return num[cur] + lv + rv;
        
        //자신 노드들 중 제일 작은 값과 자신의 값의 합이 max보다 작거나 같으면 한개만 자르면 된다.
        if(num[cur] + Math.min(lv, rv) <= max){
            size+=1;
            return num[cur] + Math.min(lv, rv);
        }
        
        //둘 다 잘라야하는 경우 
        //맨 밑단 노드 값이 max보다 작은 경우는 X
        //low가 제일 큰 노드를 기준으로 잡히기 때문에 무조건 첫번째 if에서 통과
        size += 2;
        return num[cur];
        
    }
}