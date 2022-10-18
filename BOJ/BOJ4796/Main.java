package BOJ.BOJ4796;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int tc = 1;
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int L = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      if (L == 0 && P == 0 && V == 0) break;
      int quotient = V / P;
      int remainder = V % P;
      int ans = quotient * L;
      if (remainder < L) {
        ans += remainder;
      } else {
        ans += L;
      }
      sb.append("Case ").append(tc).append(": ").append(ans).append("\n");
      tc++;
    }
    System.out.println(sb);
  }
}
