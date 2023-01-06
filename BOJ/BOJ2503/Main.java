package BOJ.BOJ2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, String> numbers = new HashMap<>();
    static Map<String, String> removed = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        init();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            check(input, strike, ball);
        }
        System.out.println(numbers.size());
    }


    private static void init() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i == j || i == k || j == k) continue;
                    StringBuilder sb = new StringBuilder();
                    String number = sb.append(i).append(j).append(k).toString();
                    numbers.put(number, number);
                }
            }
        }
    }

    private static void check(String input, int strike, int ball) {
        for (String number : numbers.values()) {
            int sCount = 0;
            int bCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j && number.charAt(i) == input.charAt(j)) sCount++;
                    if (i != j && number.charAt(i) == input.charAt(j)) bCount++;
                }
            }
            if (sCount != strike || bCount != ball) {
                removed.put(number, number);
            }
        }
        for (String number : removed.keySet()) {
            numbers.remove(number);
        }
        removed.clear();
    }
}
