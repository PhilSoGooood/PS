package BOJ.BOJ2822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] scores = new int[8];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 8; i++) {
			int N = Integer.parseInt(br.readLine());
			scores[i] = N;
			map.put(N, i+1);
		}
		int sum = 0;
		int[] index = new int[5];
		Arrays.sort(scores);
		for (int i = 3; i < 8; i++) {
			sum += scores[i];
			index[i-3] = map.get(scores[i]);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(sum + "\n");
		Arrays.sort(index);
		for (int i : index) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
}
