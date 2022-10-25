package BOJ.BOJ16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MN = br.readLine().split(" ");
        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);
        int[] snacks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        Arrays.sort(snacks);
        int st = 1;
        int end = snacks[N - 1];
        int ans = 0;

        while (st < end) {
            int mid = (st + end + 1) / 2;
            if (check(N, M, mid, snacks)) {
                st = mid;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean check(int N, int M, int mid, int[] snacks) {
        if (mid == 0) {
            return false;
        }
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            count += snacks[i] / mid;
        }
        return count >= M;
    }
}
