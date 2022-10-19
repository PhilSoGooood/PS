package BOJ.BOJ1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(br.readLine());
    int numerator;
    int denominator;
    int count = 0;
    int num = 1;
    while (count + num < X){
      count += num;
      num++;
    }
    if (num % 2 == 0) {
      numerator = X - count;
      denominator = num + 1 - numerator;
    } else {
      denominator = X - count;
      numerator = num + 1 - denominator;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(numerator).append("/").append(denominator);
    System.out.println(sb);
  }
}
