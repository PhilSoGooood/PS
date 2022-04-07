package BOJ.BOJ2407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		BigInteger[][] combination = new BigInteger[n+1][n+1];
		for (int i = 1; i < n + 1; i++) {
			combination[i][i] = new BigInteger("1");
			combination[i][0] = new BigInteger("1");
		}
		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j < i; j++) {
				combination[i][j] = combination[i-1][j-1].add(combination[i-1][j]);
			}
		}
		System.out.println(combination[n][m]);
	}
}
