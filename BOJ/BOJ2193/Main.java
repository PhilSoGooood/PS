package BOJ.BOJ2193;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static long[] numbers;
	public static void fibo(int N) {
		for(int i=2; i<N+1; i++){
			numbers[i] = numbers[i-1] + numbers[i-2];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		numbers = new long[N+1];
		numbers[1] = 1;
		fibo(N);
		bw.write(numbers[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
