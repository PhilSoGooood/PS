package BOJ.BOJ2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		String[] input = br.readLine().split(" ");
		int[] numbers = new int[N];
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		answer[0] = numbers[0];
		for (int i = 1; i < K; i++) {
			answer[i] = answer[i-1] + numbers[i];
		}
		int max = answer[K-1];
		for (int i = K; i < N; i++) {
			answer[i] = answer[i-1] + numbers[i] - numbers[i-K];
			if (answer[i] > max) max = answer[i];
		}
		System.out.println(max);
	}
}
