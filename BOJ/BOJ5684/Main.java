package BOJ.BOJ5684;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int idx = 0;
		long[] numbers = new long[N];
		while (st.hasMoreTokens()) {
			StringBuffer sb = new StringBuffer(st.nextToken());
			numbers[idx++] = Long.parseLong(sb.reverse().toString());
		}

		while (idx < N) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				StringBuffer sb = new StringBuffer(st.nextToken());
				numbers[idx++] = Long.parseLong(sb.reverse().toString());
			}
		}
		Arrays.sort(numbers);
		for (long number : numbers) {
			bw.write(number + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
