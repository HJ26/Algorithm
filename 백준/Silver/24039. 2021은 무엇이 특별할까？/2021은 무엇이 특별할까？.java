import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(specialNum(N, 110)));

    bw.flush();
    br.close();
    bw.close();
  }

  static int specialNum(int N, int max) {
    boolean[] isPrime = sieveOfEratosthenes(max);
    ArrayList<Integer> primes = new ArrayList<>();

    for (int i = 2; i < isPrime.length; i++) {
      if (!isPrime[i])
        primes.add(i);
    }

    for (int i = 1; i < primes.size(); i++) {
      if (primes.get(i - 1) * primes.get(i) > N)
        return primes.get(i - 1) * primes.get(i);
    }

    return 0;
  }

  static boolean[] sieveOfEratosthenes(int max) {
    boolean[] isPrime = new boolean[max + 1];

    for (int i = 2; i * i <= max; i++)
      if (!isPrime[i])
        for (int j = i * i; j <= max; j += i)
          isPrime[j] = true;

    return isPrime;
  }
}