package BOJ.BOJ11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		long[] numbers = new long[N+1];
		long[] result = new long[N+1];
		for (int i = 1; i < N+1; i++) {
			numbers[i] = Long.parseLong(input[i-1]);
		}
		result[1] = numbers[1];
		long max = result[1];
		for (int i = 2; i < N+1; i++) {
			result[i] = numbers[i];
			for (int j = 1; j < i; j++) {
				if(numbers[j] < numbers[i]){
					if (result[i] < result[j] + numbers[i]) {
						result[i] = result[j] + numbers[i];
						if (result[i] > max) {
							max = result[i];
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}
