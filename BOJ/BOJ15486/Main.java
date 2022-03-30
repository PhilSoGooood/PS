package BOJ.BOJ15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N+1][2];
		for (int i = 1; i < N + 1; i++) {
			String[] input = br.readLine().split(" ");
			schedule[i][0] = Integer.parseInt(input[0]);
			schedule[i][1] = Integer.parseInt(input[1]);
		}
		int[] profit = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			if (profit[i-1] > profit[i]) {
				profit[i] = profit[i-1];
			}
			if (i + schedule[i][0] > N + 1) {
				continue;
			}
			if (profit[i + schedule[i][0] - 1] < profit[i - 1] + schedule[i][1]) {
				profit[i +schedule[i][0] -1] = profit[i - 1] + schedule[i][1];
			}
		}
		System.out.println(profit[N]);
	}
}
