package BOJ.BOJ11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = NK[0];
		int K = NK[1];
		int[][] comb = new int[N+1][N+1];

		for (int i = 1; i < N + 1; i++) {
			comb[i][0] = 1;
			comb[i][i] = 1;

			for (int j = 1; j < i; j++) {
				comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]) % 10007;
			}
		}
		System.out.println(comb[N][K]);

	}
}
