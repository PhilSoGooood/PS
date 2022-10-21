package BOJ.BOJ9613;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < t; tc++) {
      int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      long ans = 0;
      for (int i = 1; i < numbers.length; i++) {
        for (int j = i + 1; j < numbers.length; j++) {
          ans += gcd(numbers[i], numbers[j]);
        }
      }
      bw.write(ans + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
  private static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a%b);
  }
}
