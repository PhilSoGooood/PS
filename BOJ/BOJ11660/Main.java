package BOJ.BOJ11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int M;
	static int[][] matrix;
	static int[][] total;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String[] size = br.readLine().split(" ");
		N = Integer.parseInt(size[0]);
		M = Integer.parseInt(size[1]);
		matrix = new int[N+1][N+1];
		total = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 1; j < N+1; j++) {
				matrix[i][j] = Integer.parseInt(line[j-1]);
			}
		}
		int sum = 0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				sum += matrix[i][j];
				total[i][j] = sum;
			}
		}
		for (int i = 0; i < M; i++) {
			String[] area = br.readLine().split(" ");
			int x1 = Integer.parseInt(area[0]);
			int y1 = Integer.parseInt(area[1]);
			int x2 = Integer.parseInt(area[2]);
			int y2 = Integer.parseInt(area[3]);
			int ans = 0;
			for (int n = x1; n < x2 + 1; n++) {
				if (y1 == 1) {
					ans += (total[n][y2] - total[n-1][N]);
				}else{
					ans += (total[n][y2] - total[n][y1-1]);}

			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}
