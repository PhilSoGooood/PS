package BOJ.BOJ11501;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Integer[] prices = Arrays.stream(br.readLine().split(" "))
				.map(Integer::parseInt)
				.toArray(Integer[]::new);
			long result = 0;
			long price = prices[prices.length - 1];
			for (int i = prices.length - 1; i >= 0; i--) {
				if (prices[i] < price) {
					result += price - prices[i];
				} else if (prices[i] > price) {
					price = prices[i];
				}
			}
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
