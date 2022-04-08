package BOJ.BOJ1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	static boolean[]visited;
	static int[][] matrix;
	static int N;
	static int M;
	static int V;
	static StringBuilder sb;
	public static void dfs(int x) {
		visited[x] = true;
		sb.append(x + " ");
		for (int i = 1; i < N + 1; i++) {
			if (matrix[x][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs() {
		Deque<Integer>dq = new LinkedList<>();
		dq.add(V);
		sb.append(V + " ");
		visited[V] = true;
		while (!dq.isEmpty()) {
			int node = dq.pollFirst();
			for (int i = 1; i < N + 1; i++) {
				if (matrix[node][i] == 1 && !visited[i]) {
					sb.append(i + " ");
					visited[i] = true;
					dq.addLast(i);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		V = Integer.parseInt(input[2]);
		sb = new StringBuilder();

		matrix = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			String[] node = br.readLine().split(" ");
			int x = Integer.parseInt(node[0]);
			int y = Integer.parseInt(node[1]);
			matrix[x][y] = matrix[y][x] = 1;
		}

		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs();
		System.out.println(sb);
	}
}
