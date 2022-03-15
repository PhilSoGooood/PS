package BOJ.BOJ1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] numbers = new int[N][N];
		for(int i=0; i<N; i++){
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < i+1; j++) {
				numbers[i][j] = Integer.parseInt(input[j]);
			}
		}
		int[][] result = new int[N][N];
		result[0][0] = numbers[0][0];
		for(int i=0; i<N-1; i++){
			for (int j = 0; j < i + 1; j++) {
				int tmp = result[i][j] + numbers[i+1][j];
				if(tmp > result[i+1][j]){
					result[i+1][j] = tmp;
				}
				int tmp2 = result[i][j] + numbers[i+1][j+1];
				if(tmp2 > result[i+1][j+1]){
					result[i+1][j+1] = tmp2;
				}
			}
		}
		int max = 0;
		for (int num : result[N - 1]) {
			if (max < num) {
				max = num;
			}
		}
		System.out.println(max);
	}
}
