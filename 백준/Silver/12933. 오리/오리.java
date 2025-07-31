import java.io.*;
import java.util.*;

public class Main {
    
    static final int N = 5;
    static char[] sound = {'q', 'u', 'a', 'c', 'k'};
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sounds = br.readLine();
        int len = sounds.length();
        boolean[] used = new boolean[len];
        if (len % 5 != 0 || sounds.charAt(0) != 'q') {
            System.out.println(-1);
            return;
        }

        int totalDuck = 0;
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;

            int idx = 0;
            ArrayList<Character> list = new ArrayList<>();
            for (int j = i; j < len; j++) {
                if (!used[j] && sound[idx] == sounds.charAt(j)) {
                    used[j] = true;
                    list.add(sound[idx]);
                    idx = (idx + 1) % N;
                }
            }

            int duckLen = list.size();
            if (duckLen != 0 && duckLen % N == 0) {
                totalDuck++;
            } else {
                System.out.println(-1);
                return;
            }
        }
        br.close();
        System.out.println(totalDuck);
    }
}