package BOJ.BOJ2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		int score = arr[N-1];
		for (int i = N - 2; i >= 0; i--) {
			if (arr[i] < score) score = arr[i];
			else {
				int tmp = arr[i] - score + 1;
				ans += tmp;
				score = arr[i] - tmp;
			}
		}
		System.out.println(ans);
	}
}
