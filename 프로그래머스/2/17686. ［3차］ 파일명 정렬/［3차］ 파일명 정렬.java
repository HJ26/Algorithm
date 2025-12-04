import java.util.*;
 
class Solution {
    
    static class File {
        
        int idx;
        String head;
        int num;
        String filename;
        
        public File(int idx, String head, String number, String filename){
            this.idx = idx;
            this.head = head.toUpperCase();
            this.num = Integer.parseInt(number);
            this.filename = filename;
        }
    }
    
    public String[] solution(String[] files) {
        
        File[] filelist = new File[files.length];
        for(int i = 0; i < files.length; i++){
            
            String[] tmp = new String[2];
            int start = 0, end;
            for(int j=0;j<2;j++){
                end = split(start,files[i]);
                tmp[j] = files[i].substring(start, end);
                start = end;
            }
            
            filelist[i] = new File(i,tmp[0], tmp[1], files[i]);
        }
        
        //정렬
        Arrays.sort(filelist, (o1,o2)-> {
           
            if(!o1.head.toUpperCase().equals(o2.head.toUpperCase())){
               return o1.head.compareTo(o2.head);
            }else if(o1.num != o2.num){
               return o1.num - o2.num;
            }else{
               return o1.idx - o2.idx;
            }
        });
        
        //답 저장
        String[] answer = new String[files.length];
        int i = 0;
        for(File file : filelist){
            answer[i++] = file.filename;
        }
        
        return answer;
    }
    
    public int split(int i, String filename){
        boolean isNum = filename.charAt(i)>='0' && filename.charAt(i) <= '9';
        for(;i<filename.length();i++){
            if(isNum != (filename.charAt(i)>='0' && filename.charAt(i) <= '9')){
                break;
            }
        }
        return i;
    }
}