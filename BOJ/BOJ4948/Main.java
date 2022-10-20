package BOJ.BOJ4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    boolean[] primes = new boolean[250000];
    Arrays.fill(primes, true);
    primes[0] = false;
    primes[1] = false;

    for (int i = 2; i * i < primes.length; i++) {
      if (!primes[i]) continue;
      for (int j = 2 * i; j < primes.length; j += i) {
        if (primes[j]) primes[j] = false;
      }
    }
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n;
    while ((n = Integer.parseInt(br.readLine())) != 0) {
      int count = 0;
      for (int i = n + 1; i <= 2 * n; i++) {
        if (primes[i]) count++;
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb);
  }
}
