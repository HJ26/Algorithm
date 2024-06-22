import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String y = br.readLine();
        String z = br.readLine();

        char xArr[] = x.toCharArray();
        char yArr[] = y.toCharArray();
        char zArr[] = z.toCharArray();

        int k = Integer.parseInt(br.readLine());

        combination(xArr, new boolean[xArr.length], 0, k);
        combination(yArr, new boolean[yArr.length], 0, k);
        combination(zArr, new boolean[zArr.length], 0, k);


        ArrayList<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) >= 2){
                list.add(key);
            }
        }

        if(list.size() == 0){
            System.out.println(-1);
            return;
        }

        Collections.sort(list);

        for(String ans : list) System.out.println(ans);

    }

    public static void combination(char arr[], boolean visited[], int start, int r){
        if(r == 0){
            StringBuilder sb = new StringBuilder("");

            for(int i=0; i<arr.length; i++)
                if(visited[i]) sb.append(arr[i]);

            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);

            return;
        }

        for(int i=start; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
}