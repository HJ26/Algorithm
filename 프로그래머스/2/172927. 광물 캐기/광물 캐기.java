import java.util.*;
class Solution {
    
    static class Group implements Comparable<Group> {
        int nDia;
        int nIron;
        int nStone;
        
        public Group(int nDia, int nIron, int nStone){
            this.nDia = nDia;
            this.nIron = nIron;
            this.nStone = nStone;
        }
        
        public int compareTo(Group g){
            if(this.nDia == g.nDia){
                if(this.nIron == g.nIron) return g.nStone - this.nStone;
                return g.nIron - this.nIron;
            }
            return g.nDia - this.nDia;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int idx = 0;
        Group gTmp = new Group(0,0,0);
        List<Group> groups = new ArrayList<>();
        
        
        int totalPick = picks[0] + picks[1] + picks[2];
        for(int i = 0; i < minerals.length && i < totalPick*5; i++){
            
            if(minerals[i].equals("diamond")) gTmp.nDia++;
            else if(minerals[i].equals("iron")) gTmp.nIron++;
            else gTmp.nStone++;
            
            idx++;
            
            if(idx == 5){
                groups.add(new Group(gTmp.nDia, gTmp.nIron, gTmp.nStone));
                gTmp = new Group(0,0,0);
                idx = 0;
            }
        }
        
        if(idx != 0){
            groups.add(new Group(gTmp.nDia, gTmp.nIron, gTmp.nStone));
        }
        
        Collections.sort(groups);
        
        idx = 0;
        for( Group g : groups ){
            
            while(idx < 3 && picks[idx] == 0) idx++;
            if(idx == 3) break;
            picks[idx]--;
            
            switch(idx){
                case 0:
                    answer += (g.nDia + g.nIron + g.nStone);
                    break;
                case 1:
                    answer += (g.nDia * 5 + g.nIron + g.nStone);
                    break;
                case 2:
                    answer += (g.nDia * 25 + g.nIron * 5 + g.nStone);
                    break;
            }
        }
        return answer;
    }
}