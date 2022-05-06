package BOJ.BOJ1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			schedule[i][0] = Integer.parseInt(input[0]);
			schedule[i][1] = Integer.parseInt(input[1]);
		}
		Arrays.sort(schedule, ((o1, o2) -> {
			return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
		}));
		int end = Integer.MIN_VALUE;
		int cnt = 0;
		for (int[] ints : schedule) {
			if (ints[0] >= end) {
				cnt++;
				end = ints[1];
			}
		}
		System.out.println(cnt);
	}
}
