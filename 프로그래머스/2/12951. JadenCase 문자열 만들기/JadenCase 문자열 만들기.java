import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean flag = true;
        for(String str : s.toLowerCase().split("")){
            if(flag) sb.append(str.toUpperCase());
            else sb.append(str);
            flag = str.equals(" ") ? true : false;
        }
        
        System.out.println(sb);
        return sb.toString();
    }
}