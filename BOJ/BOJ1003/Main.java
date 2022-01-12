package BOJ.BOJ1003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
BOJ1003 피보나치 함수
 */
public class Main {
	public static int[] fibo(int num) {
		int[] current = new int[2];
		int[] X = {1, 0};
		int[] Y = {0, 1};
		if(num == 0) return X;
		if(num == 1) return Y;
		for (int i = 2; i < num+1; i++) {
			current[0] = X[0] + Y[0];
			current[1] = X[1] + Y[1];
			X[0] = Y[0];
			X[1] = Y[1];
			Y[0] = current[0];
			Y[1] = current[1];
		}
		return current;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] result = fibo(N);
			bw.write( result[0]+ " " + result[1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
