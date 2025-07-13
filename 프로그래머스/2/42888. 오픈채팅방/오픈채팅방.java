import java.util.*;

class Solution {
    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        Map<String, String> map = new HashMap<>();
        Queue<String[]> que = new LinkedList<>();
        
        for(String rec : record){
            StringTokenizer st = new StringTokenizer(rec);
            String act = st.nextToken();
            String id = st.nextToken();
            
            if(!act.equals("Change")) que.add(new String[] {act, id});
            if(!act.equals("Leave")) {
                String nick = st.nextToken();
                map.put(id, nick);
            }
        }
        
        int idx = 0;
        while(!que.isEmpty()){
            StringBuilder sb = new StringBuilder();
            String[] cur = que.poll();
            if(cur[0].equals("Enter")) 
                answer.add(sb.append(map.get(cur[1])).append("님이 들어왔습니다.").toString());
            else answer.add(sb.append(map.get(cur[1])).append("님이 나갔습니다.").toString());
        }
        return answer;
    }
}