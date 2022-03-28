package BOJ.BOJ11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		long[] cost = new long[N+1];
		long[] dp = new long[N+1];
		for (int i = 1; i < N+1; i++) {
			cost[i] = Integer.parseInt(input[i-1]);
			dp[i] = Integer.parseInt(input[i-1]);
		}
		for (int i = 2; i < N + 1; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
			}
		}
		System.out.println(dp[N]);
	}
}
