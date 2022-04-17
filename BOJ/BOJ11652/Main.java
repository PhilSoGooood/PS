package BOJ.BOJ11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		long count = 0;
		long maxValue = arr[0];
		long maxCount = 0;
		count++;

		for (int i = 1; i < N; i++) {
			if (arr[i] != arr[i - 1]) {
				if (count > maxCount) {
					maxCount = count;
					maxValue = arr[i-1];
				}
				count = 0;
			}
			count++;
		}
		if (count > maxCount) maxValue = arr[N-1];
		System.out.println(maxValue);
	}
}
