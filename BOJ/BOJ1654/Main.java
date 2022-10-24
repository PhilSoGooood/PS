package BOJ.BOJ1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] KN = br.readLine().split(" ");
        int K = Integer.parseInt(KN[0]);
        int N = Integer.parseInt(KN[1]);
        int[] lines = new int[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(lines, K, N));
    }

    private static long solution(int[] lines, int K, int N) {
        long st = 1L;
        long end = Integer.MAX_VALUE;
        while (st < end) {
            int sum = 0;
            long mid = (st + end) / 2;
            for (int i = 0; i < K; i++) {
                sum += lines[i] / mid;
            }
            if (sum >= N) {
                st = mid;
            } else {
                end = mid - 1;
            }
        }
        return st;
    }
}
