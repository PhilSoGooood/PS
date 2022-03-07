package BOJ.BOJ2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		int[][] score = new int[N+1][2];
		score[1][0] = stairs[1];
		for(int i=2; i<N+1; i++){
			score[i][0] = Math.max(score[i-2][0], score[i-2][1]) + stairs[i];
			score[i][1] = score[i-1][0] + stairs[i];
		}
		System.out.println(Math.max(score[N][0], score[N][1]));
	}
}
