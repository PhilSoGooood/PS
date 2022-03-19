package BOJ.BOJ10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][10];
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;
		for (int i = 2; i < N + 1; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i-1][j+1] % 1000000000;
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][j - 1] % 1000000000;
				} else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % 1000000000;
				}
			}
		}
		long answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += dp[N][i];
		}
		System.out.println(answer % 1000000000);
	}
}
