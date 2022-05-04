package BOJ.BOJ1431;

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
		String[] guitars = new String[N];
		for (int i = 0; i < N; i++) {
			guitars[i] = br.readLine();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1 - i; j++) {
				if (guitars[j+1].length() > guitars[j].length()) {
					continue;
				} else if (guitars[j+1].length() < guitars[j].length()) {
					String tmp = guitars[j+1];
					guitars[j+1] = guitars[j];
					guitars[j] = tmp;
				} else if (guitars[j+1].length() == guitars[j].length()) {
					int sumA = 0;
					int sumB = 0;
					for (int x = 0; x < guitars[j+1].length(); x++) {
						if ('0' <= guitars[j+1].charAt(x) && guitars[j+1].charAt(x) <= '9') {
							sumA += guitars[j+1].charAt(x) - '0';
						}
						if ('0' <= guitars[j].charAt(x) && guitars[j].charAt(x) <= '9') {
							sumB += guitars[j].charAt(x) - '0';
						}
					}
					if (sumA < sumB) {
						String tmp = guitars[j+1];
						guitars[j+1] = guitars[j];
						guitars[j] = tmp;
					} else if (sumA == sumB) {
						for (int x = 0; x < guitars[j+1].length(); x++) {
							if (guitars[j+1].charAt(x) < guitars[j].charAt(x)) {
								String tmp = guitars[j+1];
								guitars[j+1] = guitars[j];
								guitars[j] = tmp;
								break;
							} else if(guitars[j+1].charAt(x) > guitars[j].charAt(x)) break;
						}
					}
				}
			}
		}
		for (String guitar : guitars) {
			bw.write(guitar + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
