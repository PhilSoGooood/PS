package BOJ.BOJ1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        long[] dp = new long[N+1];
        for (int i = 1; i < N+1; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        int min = Integer.MAX_VALUE;
        int end = 1;
        for (int st = 0; st < N; st++) {
            while (end < N+1 && dp[end] - dp[st] < S) end++;
            if (end == N+1) break;
            min = Math.min(min, end-st);
        }
        if (min == Integer.MAX_VALUE) min = 0;
        System.out.println(min);
    }
}
