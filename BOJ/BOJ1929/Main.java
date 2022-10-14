package BOJ.BOJ1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] numbers = new boolean[N + 1];
		Arrays.fill(numbers, true);

		numbers[0] = false;
		numbers[1] = false;

		for (int i = 2; i * i <= N; i++) {
			if (!numbers[i])
				continue;

			for (int j = i * i; j <= N; j += i) {
				numbers[j] = false;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (numbers[i])
				sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
