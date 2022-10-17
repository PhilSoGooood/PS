package BOJ.BOJ11050;

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

		int[][] combi = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			combi[i][0] = 1;
			combi[i][i] = 1;
			for (int j = 1; j < i; j++) {
				combi[i][j] = combi[i-1][j] + combi[i-1][j-1];
			}
		}
		System.out.println(combi[N][K]);
	}
}
