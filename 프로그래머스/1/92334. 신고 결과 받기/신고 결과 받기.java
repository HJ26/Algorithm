import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int N = id_list.length;
        int[] answer = new int[N];
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            map.put(id_list[i], i);
        }
        
        StringTokenizer st;
        int[][] routes = new int[N][N];
        for(String id : report){
            st = new StringTokenizer(id);
            String to = st.nextToken();
            String from = st.nextToken();
            routes[map.get(from)][map.get(to)] = 1;
        }
        
        
        for(int i = 0; i < N; i++){
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j < N; j++){
                if(routes[i][j] == 1) stack.push(j);
            }
            if(stack.size() >= k){
                while(!stack.isEmpty()) answer[stack.pop()]++;
            }
        }
        
        return answer;
    }
}