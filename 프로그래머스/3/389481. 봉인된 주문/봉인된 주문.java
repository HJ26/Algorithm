import java.util.*;

class Solution {
    
    static final int nAlpha = 26;
    
    public String solution(long n, String[] bans) {
        String answer = "";
        
        List<String> banList = Arrays.asList(bans);
        Collections.sort(banList, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()) return s1.compareTo(s2);
                return s1.length() - s2.length();
            }
        });
        
        for(String ban : banList){
            long num = getNum(ban);
            if(num <= n) n++;
            else break;
        }
        
        answer = getString(n);
        
        return answer;
    }
    
    
    private long getNum(String str){
        long num = 0;
        for(int i = 0; i < str.length(); i++){
            num += Math.pow(nAlpha, i) * (str.charAt(str.length()-1-i)-'a'+1);
        }
        return num;
    }
    
    private String getString(long n){
        
        StringBuilder sb = new StringBuilder();
        while( n > 0){
            n--;
            sb.append((char) (n % nAlpha + 'a') );
            n /= nAlpha;
        }
        
        return sb.reverse().toString();
    }
}