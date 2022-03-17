package BOJ.BOJ11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int[] length = new int[N];
		Arrays.fill(length, 1);
		int answer = 1;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] < numbers[i] && length[j] >= length[i]) {
					length[i] = length[j]+1;
					if (length[i] > answer) {
						answer = length[i];
					}
				}
			}
		}
		System.out.println(answer);
	}
}
