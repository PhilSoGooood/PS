package BOJ.BOJ6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			System.out.println(solution(M, N, x, y));
		}
	}

	private static int solution(int M, int N, int x, int y) {
		if (y == N) y = 0;
		for (int i = x; i <= M*N; i+=M) {
			if (i % N == y) {
				return i;
			}
		}
		return -1;
	}
}
