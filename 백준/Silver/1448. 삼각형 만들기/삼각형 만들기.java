import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) list.add(Integer.parseInt(br.readLine()));
        list.sort(Comparator.reverseOrder());

        int a, b, c;
        for (int i = 0; i < list.size() - 2; i++) {
            a = list.get(i);
            b = list.get(i + 1);
            c = list.get(i + 2);

            if (b + c > a) {
                System.out.println(a + b + c);
                return;
            }
        }

        System.out.println(-1);
    }
}