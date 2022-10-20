package BOJ.BOJ1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
BOJ1676 팩토리얼 0의 개수
10 = 2 x 5이므로 소인수 분해해서 5의 개수를 구해준다.
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int fiveCount = 0;
		int num;
		for (int i = 5; i <= N; i+=5) {
			num = i;
			while (num % 5 == 0) {
				fiveCount++;
				num /= 5;
			}
		}
		System.out.println(fiveCount);
	}
}

