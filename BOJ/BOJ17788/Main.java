package BOJ.BOJ17788;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		int divider  = 1_000_000_000;
		boolean isNegative = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N < 0) {
			isNegative = true;
			N = -N;
		}
		int[] dp = new int[N + 3];
		if (isNegative) {
			dp[0] = 0;
			dp[1] = 1;
			for (int i = 2; i < N+3; i++) {
				dp[i] = (dp[i - 2] - dp[i - 1]) % divider;
			}
		} else {
			dp[0] = 0;
			dp[1] = 1;
			for (int i = 2; i < N + 1; i++) {
				dp[i] = (dp[i-1] + dp[i-2]) % divider;
			}
		}
		int ans = dp[N];
		if (ans == 0) {
			System.out.println(0);
		} else if (ans < 0) {
			System.out.println(-1);
		} else {
			System.out.println(1);
		}
		System.out.println(Math.abs(ans));
	}
}
