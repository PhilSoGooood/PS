package BOJ.BOJ11728;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int[] A = new int[N];
		int[] B = new int[M];
		int[] numbers = new int[N+M];
		String[] inputA = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(inputA[i]);
		}
		String[] inputB = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(inputB[i]);
		}
		int i=0;
		int j=0;
		for (int idx = 0; idx < N + M; idx++) {
			if (i >= N && j < M) {
				numbers[idx] = B[j];
				j++;
			} else if (i < N && j >= M) {
				numbers[idx] = A[i];
				i++;
			} else if (A[i] <= B[j] && i < N) {
				numbers[idx] = A[i];
				i++;
			} else if (A[i] > B[j] && j < M) {
				numbers[idx] = B[j];
				j++;
			}
		}
		for (int number : numbers) {
			bw.write(number + " ");
		}
		bw.flush();
		bw.close();
	}
}
