import java.util.*;

class Solution {
    
    // 트리
    static class Tree{
        Node root;
        int size;
        
        // 트리 초기화
        public Tree(Node root){
            this.root = root;
            this.size = 1;
        }
        
        // 트리에 새로운 노드 추가 ( 부모 노드를 모르는 경우 )
        public void addNode(Node node){
            addNode(root, node);
            size++;
        }
        
        // 부모 노드 찾아서 추가
        private void addNode(Node parent, Node child){
            
            int parentX = parent.x;
            int parentY = parent.y;
            
            int childX = child.x;
            int childY = child.y;
            
            // 자식 노드가 왼쪽에 있는 경우
            if(childX < parentX){
                // 현재 부모노드의 왼쪽 자식 노드가 비어 있는지 확인
                if(parent.l == null){       // 비어있으면 자식으로 저장
                    parent.l = child;           
                }else if( childY < parent.l.y ){
                    // 비어 있지 않은데 현재 자식노드가 지금 추가하려는 노드보다 더 높이 있을 때
                    // 그 자식노드의 자식노드로 추가
                    addNode(parent.l, child);
                }else{  // 원래의 자식노드가 지금 추가하려는 노드보다 아래에 있을 때
                    addNode(child, parent.l);
                    parent.l = child;
                }
            }else{  // 자식 노드가 오른쪽에 있는 경우
                if(parent.r == null){       // 비어있으면 자식으로 저장
                    parent.r = child;           
                }else if( childY < parent.r.y ){
                    // 비어 있지 않은데 현재 자식노드가 지금 추가하려는 노드보다 더 높이 있을 때
                    // 그 자식노드의 자식노드로 추가
                    addNode(parent.r, child);
                }else{  // 원래의 자식노드가 지금 추가하려는 노드보다 아래에 있을 때
                    addNode(child, parent.r);
                    parent.r = child;
                }
            }
        }
        
        // 전위 순회
        public int[] preorder(){
            
            // 전위 순회 결과를 저장할 큐
            Queue<Integer> que = new LinkedList<>();
            
            // 루트노드부터 시작
            preorder(que, root);
            
            // 최종 결과를 배열에 저장 후 반환
            int[] rslt = new int[size];
            int idx = 0;
            while(!que.isEmpty()) rslt[idx++] = que.poll();
            
            return rslt;
        }
        
        private void preorder(Queue que, Node node){
            
            // 빈 노드면 종료
            if(node == null) return;
            
            // 자식노드 순회 전 큐에 저장
            que.add(node.idx);
            
            // 왼쪽 자식 노드부터 다시 순회
            preorder(que, node.l);
            preorder(que, node.r);
            
        }
        
        // 후위 순회
        public int[] postorder(){
            
            // 후위 순회 결과를 저장할 큐
            Queue<Integer> que = new LinkedList<>();
            
            // 루트 노트부터 시작
            postorder(que, root);
            
            // 결과를 배열에 저장 후 반환
            int[] rslt = new int[size];
            int idx = 0;
            while(!que.isEmpty()) rslt[idx++] = que.poll();
            
            return rslt;
        }
        
        
        public void postorder(Queue que, Node node){
            
            // 빈 노드면 종료
            if(node == null ) return;
            
            // 왼쪽부터 순회 시작
            postorder(que, node.l);
            postorder(que, node.r);
            
            // 자식노드 순회 다했으면 현재 노드 번호 큐에 저장
            que.add(node.idx);
            
        }
    }
    
    // 각 트리의 노드
    static class Node {
        
        int x, y, idx;      // 좌표 및 순서
        Node l, r;          // 좌우 노드
        public Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
            
            l = r = null;
        }
        
        @Override
        public String toString(){
            return "[ x = " + this.x + " , y = " + this.y + " , idx = " + this.idx + " ]";
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        
        int N = nodeinfo.length;
        int[][] answer = new int[2][N];
        
        
        // 노드 정보 저장
        Node[] nodes = new Node[N];
        for(int i = 0; i < N; i++) nodes[i] = new Node(nodeinfo[i][0],nodeinfo[i][1],i+1);
        
        // y 좌표를 기준으로 정렬
        Arrays.sort(nodes, new Comparator<Node>(){
            
            @Override
            public int compare(Node o1, Node o2){
                if(o1.y == o2.y) return o1.x - o2.x;
                return o2.y - o1.y;
            }
            
        });
        
        // 트리 만들기
        Tree tree = new Tree(nodes[0]);
        
        // 트리에 순서대로 노드 추가
        for(int i = 1; i < N; i++) tree.addNode(nodes[i]);
        
        // 전위 순회
        answer[0] = tree.preorder();
        
        // 후위 순회
        answer[1] = tree.postorder();
        
        return answer;
    }
}