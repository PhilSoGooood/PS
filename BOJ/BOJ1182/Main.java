package BOJ.BOJ1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int count = 0;

	public static void solution(int cur, int sum, int N, int S, int[] numbers) {
		if (cur == N-1) {
			if (sum == S) {count++;}
			return;
		}
		solution(cur + 1, sum, N, S, numbers);
		solution(cur + 1, sum + numbers[cur+1], N, S, numbers);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int S = Integer.parseInt(input[1]);
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);
		solution(-1, 0, N, S, numbers);
		if(S == 0) count--;
		System.out.println(count);

	}
}
