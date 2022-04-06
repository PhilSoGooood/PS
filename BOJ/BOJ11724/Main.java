package BOJ.BOJ11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		boolean[] visited = new boolean[N+1];
		int[][] matrix = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			String[] node = br.readLine().split(" ");
			int u = Integer.parseInt(node[0]);
			int v = Integer.parseInt(node[1]);
			matrix[u][v] = 1;
			matrix[v][u] = 1;
		}
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				stack.add(i);
				visited[i] = true;
				ans++;
				while (!stack.isEmpty()) {
					int idx = stack.pop();
					for (int j = 1; j < N + 1; j++) {
						if (matrix[idx][j] == 1 && !visited[j]) {
							stack.add(j);
							visited[j] = true;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
