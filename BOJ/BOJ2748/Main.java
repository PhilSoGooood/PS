package BOJ.BOJ2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] fibo = new long[N + 1];
		if (N == 0) {
			System.out.println(0);
		} else {
			fibo[1] = 1;
			for (int i = 2; i < N + 1; i++) {
				fibo[i] = fibo[i - 2] + fibo[i - 1];
			}
		}
		System.out.println(fibo[N]);
	}
}
