package BOJ.BOJ2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computerNumber = Integer.parseInt(br.readLine());
		int pairNumber = Integer.parseInt(br.readLine());
		int[][]matrix = new int[computerNumber+1][computerNumber+1];
		for (int i = 0; i < pairNumber; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			matrix[x][y] = 1;
			matrix[y][x] = 1;
		}
		Deque<Integer> dq = new LinkedList<>();
		dq.addLast(1);
		int ans = 0;
		int[] visited = new int[computerNumber+1];
		visited[1] = 1;
		while (!dq.isEmpty()) {
			int idx = dq.pollFirst();
			for (int i = 1; i < computerNumber + 1; i++) {
				if (matrix[idx][i] == 1 && visited[i] == 0) {
					dq.addLast(i);
					visited[i] = 1;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
