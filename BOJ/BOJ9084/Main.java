package BOJ.BOJ9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] coin = new int[N];
			for (int i = 0; i < N; i++) {
				coin[i] = Integer.parseInt(input[i]);
			}
			int M = Integer.parseInt(br.readLine());
			int[] dp = new int[M+1];
			dp[0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = coin[i]; j <= M; j++) {
					dp[j] += dp[j - coin[i]];
				}
			}
			System.out.println(dp[M]);
		}
	}
}
