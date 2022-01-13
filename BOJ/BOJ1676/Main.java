package BOJ.BOJ1676;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
BOJ1676 팩토리얼 0의 개수
10 = 2 x 5이므로 소인수 분해해서 5의 개수를 구해준다.
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long answer = 0;

		for (int i = 2; i <= N; i++) {
			if (i % 5 == 0) {
				int tmp = i;
				while(tmp % 5 == 0) {
					tmp /= 5;
					answer++;
				}
			}
		}
		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}

