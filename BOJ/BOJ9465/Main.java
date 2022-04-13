package BOJ.BOJ9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] n1 = br.readLine().split(" ");
			String[] n2 = br.readLine().split(" ");
			int[][] stickers = new int[N+1][2];
			for (int i = 1; i < N+1; i++) {
				stickers[i][0] = Integer.parseInt(n1[i-1]);
				stickers[i][1] = Integer.parseInt(n2[i-1]);
			}
			int[][] dp = new int[N+1][2];
			dp[1][0] = stickers[1][0];
			dp[1][1] = stickers[1][1];

			for (int i = 2; i < N + 1; i++) {
				dp[i][0] += Math.max(Math.max(dp[i-2][0], dp[i-2][1]), dp[i-1][1]) + stickers[i][0];
				dp[i][1] += Math.max(Math.max(dp[i-2][0], dp[i-2][1]), dp[i-1][0]) + stickers[i][1];
			}
			System.out.println(Math.max(dp[N][0], dp[N][1]));
		}
	}
}
