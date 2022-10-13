package BOJ.BOJ1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int count = 0;
		for (int number : numbers) {
			count += isPrime(number);
		}
		System.out.println(count);
	}

	private static int isPrime(int n) {
		if (n == 1) return 0;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return 0;
		}
		return 1;
	}
}
