package BOJ.BOJ14002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		Stack<Integer> stack  = new Stack<>();
		String[] numbers = br.readLine().split(" ");
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(numbers[i-1]);
		}
		int idx = 0;
		int ans = 0;
		int[][] dp = new int[N+1][2];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[j][0] >= dp[i][0]) {
					dp[i][0] = dp[j][0] + 1;
					dp[i][1] = j;
					if(dp[i][0] > ans){
						ans = dp[i][0];
						idx = i;
					}
				}
			}
		}
		bw.write(ans + "\n");
		while (idx != 0) {
			stack.add(arr[idx]);
			idx = dp[idx][1];
		}
		while (!stack.isEmpty()) {
			bw.write(stack.pop() + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
