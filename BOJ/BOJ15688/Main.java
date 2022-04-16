package BOJ.BOJ15688;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[2000001];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			count[num + 1000000] += 1;
		}
		for (int i = 0; i < 2000001; i++) {
			while (count[i]-- > 0) {
				bw.write(i-1000000 + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
