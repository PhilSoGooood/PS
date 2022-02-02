package BOJ.BOJ1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static long multiply(long A, long B, long C){
		if(B == 1)
			return A % C;

		long val = multiply(A, B/2, C);
		val = val * val % C;

		if(B % 2 == 0){
			return val;
		}
		return val * A % C;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long A = Integer.parseInt(input[0]);
		long B = Integer.parseInt(input[1]);
		long C = Integer.parseInt(input[2]);
		System.out.println(multiply(A, B, C));
	}
}
