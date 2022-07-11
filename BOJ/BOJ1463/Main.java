package BOJ.BOJ1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N+1];

		// 문제와 반대로 1부터 N을 만드는데 필요한 연산 횟수 세기 (1은 0이므로 2부터 시작)
		for (int i = 2; i < N + 1; i++) {
			int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, z = Integer.MAX_VALUE;

			if (i % 3 == 0) {
				// i가 3의 배수인 경우 i/3에서 3을 곱해야 i가 되므로 count[i/3]에서 1 추가
				x = count[i/3] + 1;
			}

			if (i % 2 == 0) {
				// i가 2의 배수인 경우 i/2에서 2을 곱해야 i가 되므로 count[i/2]에서 1 추가
				y = count[i/2] + 1;
			}
			z = count[i-1] + 1;
			// 이전 값에서 1을 더한 x, y, z 중 최소값이 1에서 i를 만드는데 필요한 연산의 최소 횟수
			count[i] = Math.min(Math.min(x, y), z);
		}
		//	1에서 N을 만드는데 필요한 최소 연산 횟수 출력
		System.out.println(count[N]);
	}
}
