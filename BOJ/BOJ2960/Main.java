package BOJ.BOJ2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    boolean[] numbers = new boolean[N + 1];
    Arrays.fill(numbers, true);
    numbers[0] = false;
    numbers[1] = false;
    int count = 0;
    for (int i = 2; i <= N; i++) {
      if (!numbers[i]) continue;
      numbers[i] = false;
      count++;
      if (count == K) {
        System.out.println(i);
        break;
      }
      for (int j = 2 * i; j <= N; j += i) {
        if (!numbers[j]) continue;
        numbers[j] = false;
        count++;
        if (count == K) {
          System.out.println(j);
          break;
        }
      }
    }
  }
}
