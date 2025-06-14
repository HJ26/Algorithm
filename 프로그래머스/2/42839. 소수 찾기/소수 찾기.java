import java.util.*;

class Solution {
    
    static int[] num, tmp;
    static boolean[] use;
    static int N, nPrime = 0;
    static boolean[] isPrime = new boolean[10000001];
    
    public int solution(String numbers) {
        
        getIsPrime();
        
        N = numbers.length();
        
        num = new int[N];
        tmp = new int[N];
        use = new boolean[N];
        
        String[] st = numbers.split("");
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st[i]);
        }
        
        Arrays.sort(num);
        
        for(int len = 1; len <= N; len++){
            makePrime(0,0,len);
        }
        
        
        return nPrime;
    }
    
    
    public void makePrime(int idx, int sidx, int len){
        if(sidx == len){
            checkPrime(len);
            return;
        }
        
        if(idx == N) return;
        
        for(int i = 0; i < N; i++){
            if(use[i]) continue;
            tmp[sidx] = num[i];
            use[i] = true;
            makePrime(idx+1, sidx+1, len);
            use[i] = false;
            makePrime(idx+1, sidx, len);
        }
    }
    
    public void checkPrime(int len){
        int tmpPrime = 0;
        
        for(int i = 0; i < len; i++){
            tmpPrime += (tmp[i] * Math.pow(10, (len - (i+1))));
        }
        
        if(!isPrime[tmpPrime]){
            nPrime++;
            isPrime[tmpPrime] = true;
        }
        
    }
    
    
    public void getIsPrime(){
        
        isPrime[0] = true;
        isPrime[1] = true;
        for(int i = 2; i <= Math.sqrt(10000001); i++){
            if(isPrime[i]) continue;
            for(int j = i * 2; j < 10000001; j += i ) isPrime[j] = true;
        }
        
    }
}