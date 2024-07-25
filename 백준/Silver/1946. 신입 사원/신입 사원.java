import java.io.*;
import java.util.*;

class Employee implements Comparable<Employee> {
    int paper;
    int interview;

    Employee (int paper, int interview) {
        this.paper = paper;
        this.interview = interview;
    }

    @Override
    public int compareTo(Employee o) {
        return this.paper - o.paper;
    }
}

public class Main {
    static int T, N;
    static ArrayList<Employee> list;
 
    public static void main(String[] args) throws Exception {
        Main m = new Main();
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for (int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Employee(a, b));
            }
            Collections.sort(list);
            solve();
        }
    }
    
    public static void solve() {
        int ans = 1;
        int pivot = list.get(0).interview;
        for (int i=1; i<N; i++) {
            if (list.get(i).interview < pivot) {
                ans++;
                pivot = list.get(i).interview;
            }
        }
        System.out.println(ans);
    }
}
