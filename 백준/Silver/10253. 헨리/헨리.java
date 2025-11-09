import java.io.*;
import java.util.*;

public class Main {
  public static int henry(int a, int b) {
    int n = b / a;
    if (n * a >= b) {
      return n;
    }
    return n + 1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      while (true) {
        int x = henry(a, b);

        if (a * x == b) {
          bw.write(x + "\n");
          break;
        }

        a = a * x - b;
        b = b * x;
      }
    }
      
    bw.close();
    br.close();
  }
}