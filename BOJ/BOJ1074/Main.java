package BOJ.BOJ1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int solution(int n, int r, int c) {
		int half = (int)Math.pow(2, n-1);
		if(n == 0) return 0;
		if((0 <= r && r < half) && (0 <= c && c < half))
			return solution(n-1, r , c);

		else if((0 <= r && r < half) && (half <= c && c < (int)Math.pow(2, n)))
			return half*half + solution(n-1, r, c-half);

		else if((half <= r && r < (int)Math.pow(2, n)) && (0 <= c && c < half))
			return 2*half*half + solution(n-1, r-half, c);

		return 3*half*half + solution(n-1, r-half, c-half);

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		System.out.println(solution(N, r, c));
	}
}
