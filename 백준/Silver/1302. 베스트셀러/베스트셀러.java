import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Map<String, Integer> books = new HashMap<String, Integer>();
        
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String name = br.readLine();
            if(books.containsKey(name)) books.put(name, books.get(name)+1);
            else books.put(name, 1);
        }
        int max = -1;
        String maxBook = "";
        for(String b : books.keySet()){
            if(max <= books.get(b)){
                if(max == books.get(b)){
                    maxBook = b.compareTo(maxBook) < 0 ? b : maxBook;
                }else{
                    max = books.get(b);
                    maxBook = b;
                }
            }
        }
        
        System.out.println(maxBook);
    } 
}