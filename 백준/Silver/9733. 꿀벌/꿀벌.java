import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = {"Re","Pt","Cc","Ea","Tb","Cm","Ex"};

        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String s: str) hashMap.put(s,0);
        
        double total=0;
        String data="";
        
        while((data=br.readLine())!=null){
            String[] arr = data.split(" ");
            total+=arr.length;
            for(int i=0;i<arr.length;i++){
                if(hashMap.containsKey(arr[i])){
                    hashMap.put(arr[i],hashMap.get(arr[i])+1);
                }
            }
        }
        
        for(int i=0;i<7;i++){
            System.out.printf("%s %d %.2f\n",str[i],hashMap.get(str[i]),hashMap.get(str[i])/total);
        }
        
        System.out.printf("%s %d %.2f\n","Total",(int)total,1.00);

    }
}