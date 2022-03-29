package BOJ.BOJ14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N+1][2];
		int[] dp = new int[N+1];
		int day = 0;
		for (int i = 1; i < N+1; i++) {
			String[] input = br.readLine().split(" ");
			schedule[i][0] = Integer.parseInt(input[0]);
			schedule[i][1] = Integer.parseInt(input[1]);
		}
		for (int i = 1; i < N + 1; i++) {
			day = i+schedule[i][0] - 1;
			if (dp[i - 1] > dp[i]) {
				dp[i] = dp[i-1];
			}
			if (day > N) {
				continue;
			}
			if (dp[day] < dp[i - 1] + schedule[i][1]) {
				dp[day] = dp[i - 1] + schedule[i][1];
			}
		}
		System.out.println(dp[N]);
	}
}
