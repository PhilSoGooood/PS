package BOJ.BOJ1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N + 1];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[0] = 0;
		result[1] = 1;
		for (int i = 2; i < N + 1; i++) {
			int sqrt = (int)Math.sqrt(i);
			for (int j = 0; j < sqrt + 1; j++) {
				if (result[i] > result[i - j * j]) {
					result[i] = result[i - j*j] + 1;
				}
			}
		}
		System.out.println(result[N]);
	}
}
