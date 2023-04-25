package BOJ.BOJ14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] operators = new int[4];
    private static int[] numbers;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        numbers = new int[N];
        for (int i=0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        operators = new int[4];
        input = br.readLine().split(" ");
        for (int i=0; i < 4; i++) {
            operators[i] = Integer.parseInt(input[i]);
        }

        btk(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void btk(int cur, int num) {
        if (cur == numbers.length) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for (int i=0; i < 4; i++) {
            if (operators[i] == 0) continue;
            int result = calculate(cur, i, num);
            operators[i]--;
            btk(cur+1, result);
            operators[i]++;
        }
    }

    private static int calculate(int cur, int idx, int num) {
        if (idx == 0) {
            num += numbers[cur];
        } else if (idx == 1) {
            num -= numbers[cur];
        } else if (idx == 2) {
            num *= numbers[cur];
        } else {
            num /= numbers[cur];
        }
        return num;
    }
}
