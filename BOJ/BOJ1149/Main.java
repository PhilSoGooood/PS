package BOJ.BOJ1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] houses = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				houses[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] cost = new int[N][3];
		cost[0][0] = houses[0][0];
		cost[0][1] = houses[0][1];
		cost[0][2] = houses[0][2];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if(j == 0){
					cost[i][j] = Math.min(cost[i-1][1], cost[i-1][2]);
				} else if(j == 1){
					cost[i][j] = Math.min(cost[i-1][0], cost[i-1][2]);
				} else {
					cost[i][j] = Math.min(cost[i-1][0], cost[i-1][1]);
				}
				cost[i][j] += houses[i][j];
			}
		}
		System.out.println(Math.min(Math.min(cost[N-1][0], cost[N-1][1]), cost[N-1][2]));
	}
}
