package BOJ.BOJ11931;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Integer[] numbers = new Integer[N];
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			numbers[i] = number;
		}
		Arrays.sort(numbers, Collections.reverseOrder());
		for (Integer number : numbers) {
			bw.write(number + "\n");
		}
		bw.flush();
		bw.close();
	}
}
